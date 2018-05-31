package cn.com.vector.play.service.impl;

import cn.com.vector.play.common.CommonCode;
import cn.com.vector.play.contract.DanDanCoin;
import cn.com.vector.play.contract.EggAuctionWar;
import cn.com.vector.play.contract.EggCard;
import cn.com.vector.play.service.ContractService;
import cn.com.vector.play.service.UserService;
import cn.com.vector.play.util.ConnectionUtils;
import cn.com.vector.play.util.ServiceResult;
import cn.com.vector.play.util.ServiceResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.List;

/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户服务定义
 *
 */
@Slf4j
@Service("contractService")
public class ContractServiceImpl implements ContractService {
	@Value("${contract.path}")
	private String path;
	@Value("${contract.directory}")
	private String directory;
	@Value("${contract.key-flag}")
	private String keyFlag;
	@Value("${contract.private-key}")
	private String privateKey;
	@Value("${contract.public-key}")
	private String publicKey;
	@Value("${contract.token-addr}")
	private String tokenAddr;
	@Value("${contract.card-addr}")
	private String cardAddr;
	@Value("${contract.auction-war-addr}")
	private String auctionWarAddr;
	@Value("${contract.auction-card-addr}")
	private String auctionCardAddr;

	@Override
	public ServiceResult openAward(String txHash, String addr, String cardAward, String tokenCount) {
		log.info("into open award service impl,txHash:"+txHash+",addr:"+addr+",cardAward:"+cardAward+",token:"+tokenCount);
		//TODO 检验
		//合约加载
		Web3j web3j =  ConnectionUtils.getInstall(publicKey);
		EggAuctionWar auctionWarContract = null;
		try {
			auctionWarContract = EggAuctionWar.load(auctionWarAddr, web3j, ConnectionUtils.getCredentials(keyFlag,privateKey),
                    CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
		} catch (Exception e) {
			log.error("openAward 加载合约失败,合约地址为:"+auctionWarAddr);
			log.error(e.getMessage());
		}
		//合约调用开奖
		TransactionReceipt transactionReceipt = null;
		try {
			transactionReceipt = auctionWarContract.finishWar(addr,new BigInteger(tokenCount),new BigInteger(cardAward)).send();
		} catch (Exception e) {
			log.error("openAward 合约调用开奖错误");
			log.error(e.getMessage());
		}
		log.info("startTxHash:"+txHash+",executing finish war waiting...");
		String finishTxHash = transactionReceipt.getTransactionHash();
		log.info("startTxHash:"+txHash+",finshWar seccess txHash:"+finishTxHash);
		//TODO 721合约创建token并转移
		EggCard eggCardContract = null;
		try {
			eggCardContract = EggCard.load(cardAddr, web3j, ConnectionUtils.getCredentials(keyFlag,privateKey),
					CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
		} catch (Exception e) {
			log.error("openAward 加载721合约失败,合约地址为:"+cardAddr);
			log.error(e.getMessage());
		}
		//创建合约
		TransactionReceipt cardReceipt = null;
		try {
			cardReceipt = eggCardContract.createCard(new BigInteger(cardAward),new BigInteger("0"),new BigInteger("0"),publicKey).send();
		} catch (Exception e) {
			log.error("openAward 合约调用开奖错误");
			log.error(e.getMessage());
		}
		log.info("startTxHash:"+txHash+",executing finish war waiting...");
		String cardCreateTxHash = cardReceipt.getTransactionHash();
		log.info("startTxHash:"+txHash+",cardCreateTxHash seccess cardCreateTxHash:"+cardCreateTxHash);

		List<EggCard.CreatedCardEventResponse> results =  eggCardContract.getCreatedCardEvents(cardReceipt);
		BigInteger tokenId = new BigInteger("0");
		if(results.size() > 0){
			EggCard.CreatedCardEventResponse obj = results.get(0);
			tokenId = obj.cardId;
		}else{
			log.info("获取已创建的卡牌失败");
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"获取卡牌失败,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}

		TransactionReceipt cardTransfer = null;
		try {
			cardTransfer = eggCardContract.transfer(addr,tokenId).send();
		} catch (Exception e) {
			log.error("卡牌tokenId转移失败");
			log.error(e.getMessage());
		}
		log.info("startTxHash:"+txHash+",executing transfer card waiting...");
		String cardTransferTxHash = cardTransfer.getTransactionHash();
		log.info("startTxHash:"+txHash+",cardTransferTxHash seccess transfer:"+cardTransferTxHash);

		//TODO 20合约token转移
		DanDanCoin ddcContract = null;
		try {
			ddcContract = DanDanCoin.load(tokenAddr, web3j, ConnectionUtils.getCredentials(keyFlag,privateKey),
					CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
		} catch (Exception e) {
			log.error("加载ERC20合约失败,合约地址为:"+tokenAddr);
			log.error(e.getMessage());
		}

		TransactionReceipt ddcTransfer = null;
		try {
			ddcTransfer = ddcContract.transfer(addr,new BigInteger(tokenCount)).send();
		} catch (Exception e) {
			log.error("ERCtoken 转移失败");
			log.error(e.getMessage());
		}
		log.info("startTxHash:"+txHash+",executing ddc transfer waiting...");
		String ddcTransferTxHash = ddcTransfer.getTransactionHash();
		log.info("startTxHash:"+txHash+",ddcTransferTxHash seccess transfer:"+ddcTransferTxHash);

		//TODO 数据保存
		ServiceResult serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
				ServiceResultEnum.SUCCESS.getMessage(),null);
		return serRet;
	}
}
