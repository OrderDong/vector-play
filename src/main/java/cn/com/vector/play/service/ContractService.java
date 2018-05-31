package cn.com.vector.play.service;

import cn.com.vector.play.entity.User;
import cn.com.vector.play.util.ServiceResult;

import java.util.List;
import java.util.Map;

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
