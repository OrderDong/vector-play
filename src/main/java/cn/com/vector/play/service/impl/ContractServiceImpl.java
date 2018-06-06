package cn.com.vector.play.service.impl;


import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.EthLog.LogResult;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.utils.Convert;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.core.methods.response.Log;

import cn.com.vector.play.common.CommonCode;
import cn.com.vector.play.contract.DanDanCoin;
import cn.com.vector.play.contract.EggAuctionWar;
import cn.com.vector.play.contract.EggCard;
import cn.com.vector.play.contract.EggCardMarket;
import cn.com.vector.play.contract.EggAuctionWar.AuctionSuccessfulEventResponse;
import cn.com.vector.play.dao.WarMapper;
import cn.com.vector.play.entity.DDCAuction;
import cn.com.vector.play.entity.War;
import cn.com.vector.play.service.ContractService;
import cn.com.vector.play.service.WarService;
import cn.com.vector.play.util.ConnectionUtils;
import cn.com.vector.play.util.DateUtils;
import cn.com.vector.play.util.Page;
import cn.com.vector.play.util.ServiceResult;
import cn.com.vector.play.util.ServiceResultEnum;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscription;

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
	private static String cardAddr = "0xf02F2421678A129CD22E4799954eaB73CB338555";
	
	//@Value("${contract.auction-war-addr}")
	private static String auctionWarAddr = "0x09b4685F46e44194fBf23f251ba9Ca653EbB5425";
	
	//@Value("${contract.auction-card-addr}")
	private static String auctionCardAddr = "0x9Ba6FD4103CB221bc62B0F75a862ad3315d5a74C";

	@Autowired
	private WarService warService;
	
	@Override
	public ServiceResult openAward(String txHash, String addr, String cardAward, String tokenCount) {
		log.info("into open award service impl,txHash:"+txHash+",addr:"+addr+",cardAward:"+cardAward+",token:"+tokenCount);
		War war = new War();
		war.setTxHash(txHash);
		war.setAwardUser(addr);
		warService.createWar(war, "add");
		war = warService.selectByTxHash(txHash);
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
			war.setCardId(tokenId.toString());
			war.setCardType(cardAward);
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
		war.setCardHash(cardTransferTxHash);
		if(cardTransfer.isStatusOK()) {
			war.setStatusCard(1);
		} else {
			war.setStatusCard(2);
		}
		
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
		war.setTokenCount(Integer.parseInt(tokenCount));
		war.setTokenHash(ddcTransferTxHash);
		if(ddcTransfer.isStatusOK()) {
			war.setStatusDdc(1);
		} else {
			war.setStatusDdc(2);
		}
		log.info("startTxHash:"+txHash+",ddcTransferTxHash seccess transfer:"+ddcTransferTxHash);

		//TODO 数据保存
		war.setUpdateUser(addr);
		warService.createWar(war, "update");
		log.info("此次游戏结束。startTxHash:"+txHash);
		ServiceResult serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
				ServiceResultEnum.SUCCESS.getMessage(),null);
		return serRet;
	}

	@Override
	public ServiceResult verifyAddr(String addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult verifyTransaction(String txHash, String addr) {
		// 获取交易记录，查询交易是否成功
		Web3j web3j =  ConnectionUtils.getInstall(publicKey);
		TransactionReceipt transferReceipt = null;
		try {
			for (int i = 0; i < 20; i++) {
				transferReceipt = web3j.ethGetTransactionReceipt(txHash).send().getResult();
				if(transferReceipt != null){
					break;
				} else {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (IOException e) {
			log.error("加载交易记录失败，txHash为:"+txHash);
			log.error(e.getMessage());
		}
		log.info("TxReceipt Status:"+transferReceipt.getStatus());
		if(transferReceipt.isStatusOK()) {
			String fromAddr = transferReceipt.getFrom();
			String contractAddr = transferReceipt.getTo();
			if(!fromAddr.equals(addr.toLowerCase())) {
				log.error("当前账户与交易记录不匹配，当前账户地址为:"+fromAddr);
				return null;
			}
			if(!contractAddr.equals(auctionWarAddr.toLowerCase())) {
				log.error("此交易与本平台不相关！");
				return null;
			}
			
			List<Log> list = transferReceipt.getLogs();
			String countDDC = "0x0000000000000000000000000000000000000000000000008ac7230489e80000";
			if(list.get(0).getTopics().get(2).contains(publicKey.substring(2).toLowerCase()) &&
					countDDC.equals(list.get(0).getData())) {
				ServiceResult serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
						ServiceResultEnum.SUCCESS.getMessage(),null);
				return serRet;
			}
		}
		return null;
	}

	@Override
	public Map<String,Object> marketDDCList(int pageSize, int pageNumber) {
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
			log.error("加载合约失败,合约地址为:"+auctionWarAddr);
			log.error(e.getMessage());
			e.printStackTrace();
		}
		Map<String,Object> result = new HashMap<String,Object>();
		List<DDCAuction> ddcAs = null;
		try {
			ddcAs = new ArrayList<DDCAuction>();
			List auctions = auctionWarContract.getAuctions().send();
			int currIdx = (pageNumber > 1 ? (pageNumber -1) * pageSize : 0);
			for (int i = 0; i < pageSize && i < auctions.size() - currIdx; i++) {
				System.out.println("-----------"+auctions.get(currIdx+i).toString());
				Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> auction = 
						auctionWarContract.getAuction(new BigInteger(auctions.get(currIdx+i).toString())).send();
				DDCAuction ddcA = new DDCAuction();
				ddcA.setId(auction.getValue1());
				ddcA.setSeller(auction.getValue2());
				ddcA.setSellerName(auction.getValue3());
				ddcA.setPrice(auction.getValue4());
				ddcA.setExpiresAt(auction.getValue5());
				ddcA.setSalesCount(auction.getValue6());
				ddcAs.add(ddcA);
			}
			int totalRecord = auctions.size();
			int totalPage = 0;
			if (totalRecord % pageSize == 0) {
				totalPage = totalRecord / pageSize;
			} else {
				totalPage = totalRecord / pageSize + 1;
			}
			result.put("list", ddcAs);
			result.put("pageNumber", pageNumber);
			result.put("pageSize", pageSize);
			result.put("totalRecord", totalRecord);
			result.put("totalPage", totalPage);
		} catch (Exception e) {
			log.error("获取DDC拍卖列表失败！");
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String, Object> marketCardList(int pageSize, int pageNumber) {
		//合约加载
		Web3j web3j =  ConnectionUtils.getInstall(publicKey);
		EggCardMarket eggCardMarket = null;
		EggCard eggCard = null;
		Credentials cre = null;
		try {
			cre = ConnectionUtils.getCredentials(keyFlag,privateKey);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			eggCardMarket = EggCardMarket.load(auctionCardAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
			eggCard = EggCard.load(cardAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
		} catch (Exception e) {
			log.error("加载合约失败,合约地址为:"+auctionWarAddr);
			log.error(e.getMessage());
			e.printStackTrace();
		}
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String,Object>> cardAs = null;
		try {
			cardAs = new ArrayList<Map<String,Object>>();
			List<BigInteger> eggCardMarketList = eggCardMarket.getAuctionIndex().send().getValue2();
			int currIdx = (pageNumber > 1 ? (pageNumber -1) * pageSize : 0);
			for (int i = 0; i < pageSize && i < eggCardMarketList.size() - currIdx; i++) {
				System.out.println("-----------"+eggCardMarketList.get(currIdx+i).toString());
				String tokenId = eggCardMarketList.get(currIdx+i).toString();
				
				Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger> cardAuction = 
						eggCardMarket.getCardAuction(new BigInteger(tokenId)).send();
				
				Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> card = 
				eggCard.getCard(new BigInteger(tokenId)).send();
				
				Map<String,Object> tempMap = new HashMap<String,Object>();
				tempMap.put("eType", card.getValue6());
				tempMap.put("attrId", card.getValue7());
				tempMap.put("tokenId", tokenId);
				tempMap.put("seller", cardAuction.getValue2());
				tempMap.put("priceDDC", Convert.fromWei(cardAuction.getValue3().toString(), Convert.Unit.ETHER).toPlainString());
				tempMap.put("priceDDCWei", cardAuction.getValue3());
				tempMap.put("expiresAt", DateUtils.dateToFormatStr(new Date(cardAuction.getValue4().longValue()), "yyyy-MM-dd HH:mm:ss"));
				tempMap.put("time", DateUtils.dateToFormatStr(new Date(cardAuction.getValue5().longValue()*1000), "yyyy-MM-dd HH:mm:ss"));
				cardAs.add(tempMap);
			}
			int totalRecord = eggCardMarketList.size();
			int totalPage = 0;
			if (totalRecord % pageSize == 0) {
				totalPage = totalRecord / pageSize;
			} else {
				totalPage = totalRecord / pageSize + 1;
			}
			result.put("list", cardAs);
			result.put("pageNumber", pageNumber);
			result.put("pageSize", pageSize);
			result.put("totalRecord", totalRecord);
			result.put("totalPage", totalPage);
		} catch (Exception e) {
			log.error("获取卡牌拍卖列表失败！");
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void auctionSuccessfulLogs() {
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
		}
		
		
		EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, "");
	    Event AUCTIONSUCCESSFUL_EVENT = new Event("AuctionSuccessful", 
	            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
	            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        filter.addSingleTopic(EventEncoder.encode(AUCTIONSUCCESSFUL_EVENT));
        try {
        	EthLog ethLog = web3j.ethGetLogs(filter).send();
			List<LogResult> list1 = ethLog.getResult();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
