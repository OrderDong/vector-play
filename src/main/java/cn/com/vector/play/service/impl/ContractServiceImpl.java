package cn.com.vector.play.service.impl;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Convert;

import cn.com.vector.play.common.CommonCode;
import cn.com.vector.play.contract.DanDanCoin;
import cn.com.vector.play.contract.EggAuctionWar;
import cn.com.vector.play.contract.EggCard;
import cn.com.vector.play.service.ContractService;
import cn.com.vector.play.util.ConnectionUtils;
import cn.com.vector.play.util.ServiceResult;
import cn.com.vector.play.util.ServiceResultEnum;
import lombok.extern.slf4j.Slf4j;

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
	
	//@Value("${contract.public-key}")
	private static String publicKey ="0x339177a6a2b21a8b7CE76811C86D3a2C99301355";
	
	//@Value("${contract.token-addr}")
	private static String tokenAddr = "0x4195E850A8504ef0Cc184Ac1FC22B5Ee5AF0321B";
	
	//@Value("${contract.card-addr}")
	private static String cardAddr = "0xe007E924e6E3641AB9CE0b8a4bf0c9F2F59BB83E";
	
	//@Value("${contract.auction-war-addr}")
	private static String auctionWarAddr = "0xB7182506B47A8713F95051e5D21b30f5015AB8dc";
	
	//@Value("${contract.auction-card-addr}")
	private static String auctionCardAddr = "0x7A1b2716c3bbb411877CC782fA4Bfdf80538589c";

	@Override
	public ServiceResult openAward(String txHash, String addr, String cardAward, String tokenCount) {
		log.info("into open award service impl,txHash:"+txHash+",addr:"+addr+",cardAward:"+cardAward+",token:"+tokenCount);
		//TODO 检验
		//合约加载
		Web3j web3j =  ConnectionUtils.getInstall(publicKey);
		EggAuctionWar auctionWarContract = null;
		Credentials cre = null;
		try {
			cre = ConnectionUtils.getCredentials(keyFlag,privateKey);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			auctionWarContract = EggAuctionWar.load(auctionWarAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
		} catch (Exception e) {
			log.error("openAward 加载合约失败,合约地址为:"+auctionWarAddr);
			log.error(e.getMessage());
			e.printStackTrace();
			return ServiceResult.returnResult(ServiceResultEnum.SERVICE_GENERAL_ERROR.getTypeId(),
					ServiceResultEnum.SERVICE_GENERAL_ERROR.getMessage()+"",null);
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
			eggCardContract = EggCard.load(cardAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
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
			ddcContract = DanDanCoin.load(tokenAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
		} catch (Exception e) {
			log.error("加载ERC20合约失败,合约地址为:"+tokenAddr);
			log.error(e.getMessage());
		}

		TransactionReceipt ddcTransfer = null;
		try {
			ddcTransfer = ddcContract.transfer(addr,new BigInteger(Convert.toWei(tokenCount, Convert.Unit.ETHER).toString())).send();
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
