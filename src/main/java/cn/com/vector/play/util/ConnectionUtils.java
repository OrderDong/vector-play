package cn.com.vector.play.util;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by Administrator on 2018/5/30.
 */
public class ConnectionUtils {
    private static Web3j web3j;
    private static  Admin admin;
    public static Web3j getInstall(String publicKey){
        if(web3j == null ){
            web3j = Web3j.build(new HttpService("https://ropsten.infura.io/"+publicKey));
        }
        return  web3j;
    }

    public  static Credentials getCredentials(String keyFlag,String privateKey) throws Exception {
    	byte[] key = new BASE64Decoder().decodeBuffer(keyFlag);
    	byte[] data = new BASE64Decoder().decodeBuffer(privateKey);
        byte[] str4 = Des3Util.ees3DecodeECB(key,data);
        String pwd = new String(str4,"UTF-8");
        ECKeyPair keyPair = ECKeyPair.create(Numeric.toBigInt(pwd));
        Credentials credentials = Credentials.create(keyPair);
        return credentials;
    }

    public static Admin getInstallAdmin(){
        if(admin == null ) {
            admin = Admin.build(new HttpService("http://127.0.0.1:8545"));
        }
//        Admin admin = Admin.build(new HttpService("https://ropsten.infura.io/0x339177a6a2b21a8b7CE76811C86D3a2C99301355"));
        return  admin;
    }
}
