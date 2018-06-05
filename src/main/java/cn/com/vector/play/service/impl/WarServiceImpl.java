package cn.com.vector.play.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.vector.play.dao.WarMapper;
import cn.com.vector.play.entity.War;
import cn.com.vector.play.service.WarService;
import cn.com.vector.play.util.ServiceResult;
import cn.com.vector.play.util.ServiceResultEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户服务定义
 *
 */
@Slf4j
@Service("warService")
public class WarServiceImpl implements WarService {
	@Autowired
	private WarMapper warMapper;

	@Override
	public ServiceResult createWar(War war, String flag) {
		ServiceResult serRet = null;
		if(StringUtils.isBlank(war.getTxHash())){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"TxHash,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		if("add".equals(flag)){
			war.setCreateTime(new Date());
			warMapper.insert(war);
		}
		if("update".equals(flag)){
			war.setUpdateTime(new Date());
			warMapper.updateByPrimaryKey(war);
		}
		
		serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
        		ServiceResultEnum.SUCCESS.getMessage(),null);
        return serRet;
	}

	@Override
	public War selectByTxHash(String txHash) {
		return warMapper.selectByTxHash(txHash);
	}

	@Override
	public War selectByAwardUser(String awardUser) {
		List<War> warList = warMapper.selectByAwardUser(awardUser);
		if(warList.size() > 0) {
			return warList.get(0);
		}
		return null;
	}

}
