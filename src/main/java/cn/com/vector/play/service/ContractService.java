package cn.com.vector.play.service;

import java.util.Map;

import cn.com.vector.play.util.ServiceResult;

/**
 * 
 * @author OrderDong
 * @since 20180530
 * @description 合约服务接口定义
 *
 */
public interface ContractService {
    /**
     * 开奖
     * @param txHash
     * @param addr
     * @param cardAward
     * @param token
     * @return
     */
    public ServiceResult openAward(String txHash,String addr, String cardAward,String token);

    /**
     * 校验地址有效性
     * @param addr
     * @return
     */
	public ServiceResult verifyAddr(String addr);

	/**
	 * 验证tx的交易有效性，查询事件的有效性
	 * @param txHash
	 * @return
	 */
	public ServiceResult verifyTransaction(String txHash, String addr);

	/**
	 * 获取市场蛋蛋币拍卖列表
	 * @return
	 */
	public Map<String,Object> marketDDCList(int pageSize, int pageNumber);

	/**
	 * 获取市场卡牌拍卖列表
	 * @param parseInt
	 * @param parseInt2
	 * @return
	 */
	public Map<String, Object> marketCardList(int parseInt, int pageNumber);

	public void auctionSuccessfulLogs();

	
}
