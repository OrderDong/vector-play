package cn.com.vector.play.util;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import cn.com.vector.play.common.CommonCode;
import cn.com.vector.play.contract.DanDanCoin;
import cn.com.vector.play.contract.EggAuctionWar;
import cn.com.vector.play.contract.EggCard;
import cn.com.vector.play.contract.EggCardMarket;
import sun.misc.BASE64Decoder;

/**
 * Created by Administrator on 2018/5/30.
 */
public class ConnectionUtils {
    private static Web3j web3j;
    private static  Admin admin;
    private static Credentials credentials;
    private static EggAuctionWar eggAuctionWar;
    private static EggCard eggCard;
    private static DanDanCoin canDanCoin;
    private static EggCardMarket eggCardMarket;
    public static Web3j getInstall(String publicKey){
        if(web3j == null ){
            web3j = Web3j.build(new HttpService("https://ropsten.infura.io/"+publicKey));
        }
        return  web3j;
    }

    public  static Credentials getCredentials(String keyFlag,String privateKey) throws Exception {
    	if(credentials != null){
    		return credentials;
    	}
    	byte[] key = new BASE64Decoder().decodeBuffer(keyFlag);
    	byte[] data = new BASE64Decoder().decodeBuffer(privateKey);
        byte[] str4 = Des3Util.ees3DecodeECB(key,data);
        String pwd = new String(str4,"UTF-8");
        ECKeyPair keyPair = ECKeyPair.create(Numeric.toBigInt(pwd));
        credentials = Credentials.create(keyPair);
        return credentials;
    }
    /**
     * 获取拍卖战斗合约
     * @param auctionWarAddr
     * @param cre
     * @return
     * @throws Exception
     */
    public static EggAuctionWar getEggAuctionWar(String auctionWarAddr,Credentials cre) throws Exception{
    	if(eggAuctionWar == null){
    		return EggAuctionWar.load(auctionWarAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
    	}
    	return eggAuctionWar;
    }
    
    /**
     * 获取卡牌721合约
     * @param cardAddr
     * @param cre
     * @return
     * @throws Exception
     */
    public static EggCard getEggCard(String cardAddr,Credentials cre) throws Exception{
    	if(eggCard == null){
    		return EggCard.load(cardAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
    	}
    	return eggCard;
    }
    /**
     * 获取蛋蛋币20合约
     * @param cardAddr
     * @param cre
     * @return
     * @throws Exception
     */
    public static DanDanCoin getDanDanCoin(String tokenAddr,Credentials cre) throws Exception{
    	if(canDanCoin == null){
    		return DanDanCoin.load(tokenAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
    	}
    	return canDanCoin;
    }
    
    /**
     * 获取蛋蛋币20合约
     * @param cardAddr
     * @param cre
     * @return
     * @throws Exception
     */
    public static EggCardMarket getEggCardMarket(String auctionCardAddr,Credentials cre) throws Exception{
    	if(eggCardMarket == null){
    		return EggCardMarket.load(auctionCardAddr, web3j, cre,CommonCode.GAS_PRICE, CommonCode.GAS_LIMIT);
    	}
    	return eggCardMarket;
    }

    public static Admin getInstallAdmin(){
        if(admin == null ) {
            admin = Admin.build(new HttpService("http://127.0.0.1:8545"));
        }
//        Admin admin = Admin.build(new HttpService("https://ropsten.infura.io/0x339177a6a2b21a8b7CE76811C86D3a2C99301355"));
        return  admin;
    }
}
