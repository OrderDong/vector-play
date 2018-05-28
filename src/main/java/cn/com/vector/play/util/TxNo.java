package cn.com.vector.play.util;

import java.util.UUID;

/**
 *  
 * @author mahaike
 *
 */
public class TxNo {
	public static String getTxNo() {
	    String txNo = UUID.randomUUID().toString().replaceAll("-", "");
	    return txNo;
	}
}

