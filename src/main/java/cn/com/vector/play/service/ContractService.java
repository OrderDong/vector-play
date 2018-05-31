package cn.com.vector.play.service;

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

}
