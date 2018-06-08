package cn.com.vector.play.service;

import java.util.List;

import cn.com.vector.play.entity.War;
import cn.com.vector.play.util.ServiceResult;

/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户服务接口定义
 *
 */
public interface WarService {

	/**
	 * 创建战斗交易记录
	 * @param params
	 * @return
	 */
    public ServiceResult createWar(War war, String flag);

    War selectByTxHash(String txHash);
    
    List<War> selectByAwardUser(String awardUser);
}
