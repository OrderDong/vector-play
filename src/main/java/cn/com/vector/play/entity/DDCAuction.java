package cn.com.vector.play.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.web3j.utils.Convert;

import cn.com.vector.play.util.DateUtils;

public class DDCAuction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4263464020962610417L;

	private BigInteger id;
	private String seller;
	private String sellerName;
	private BigInteger price;
	private BigInteger expiresAt;
	private BigInteger salesCount;
	public void setId(BigInteger id) {
		this.id = id;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public void setPrice(BigInteger price) {
		this.price = price;
	}
	public void setExpiresAt(BigInteger expiresAt) {
		this.expiresAt = expiresAt;
	}
	public void setSalesCount(BigInteger salesCount) {
		this.salesCount = salesCount;
	}
	public BigInteger getId() {
		return id;
	}
	public String getSeller() {
		return seller;
	}
	public String getSellerName() {
		return sellerName;
	}
	public String getPrice() {
		return Convert.fromWei(price.toString(), Convert.Unit.ETHER).toPlainString();
	}
	public String getExpiresAt() {
		return DateUtils.dateToFormatStr(new Date(expiresAt.longValue()), "yyyy-MM-dd HH:mm:ss");
	}
	public BigInteger getSalesCount() {
		return salesCount;
	}

	
}
