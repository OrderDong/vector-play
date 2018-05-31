package cn.com.vector.play.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author wd
 *
 */
public class War implements Serializable {
	private static final long serialVersionUID = -4101601833983910018L;
	
	private Long id; // 编号
	private String txHash;// 发起HASH
	private int tokenCount;// 获得20token数量
	private String cardId; // 卡牌tokenId
	private String tokenHash; // 发起划转token tx
	private String cardHash; // 发起划转card tx
	private String awardUser; // 接受人
	private int statusDdc; // 转移DDC状态
	private int statusCard; // 转移card状态
	private Date createTime;
	private Date updateTime;

	public War() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public int getTokenCount() {
		return tokenCount;
	}

	public void setTokenCount(int tokenCount) {
		this.tokenCount = tokenCount;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getTokenHash() {
		return tokenHash;
	}

	public void setTokenHash(String tokenHash) {
		this.tokenHash = tokenHash;
	}

	public String getCardHash() {
		return cardHash;
	}

	public void setCardHash(String cardHash) {
		this.cardHash = cardHash;
	}

	public String getAwardUser() {
		return awardUser;
	}

	public void setAwardUser(String awardUser) {
		this.awardUser = awardUser;
	}

	public int getStatusDdc() {
		return statusDdc;
	}

	public void setStatusDdc(int statusDdc) {
		this.statusDdc = statusDdc;
	}

	public int getStatusCard() {
		return statusCard;
	}

	public void setStatusCard(int statusCard) {
		this.statusCard = statusCard;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
