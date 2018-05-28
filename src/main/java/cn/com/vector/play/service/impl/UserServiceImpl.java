package cn.com.vector.play.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.vector.play.common.CommonCode;
import cn.com.vector.play.dao.UserDao;
import cn.com.vector.play.entity.User;
import cn.com.vector.play.service.UserService;
import cn.com.vector.play.util.ServiceResult;
import cn.com.vector.play.util.ServiceResultEnum;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户服务定义
 *
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 创建用户
     * @param user
     */
    public ServiceResult createUser(Map<String,Object> params) {
    	ServiceResult serRet=null;
    	User user = (User)params.get("user");
    	String roleId = (String)params.get("roleId");
    	String flag = (String)params.get("flag");
    	
    	//参数校验
    	if(StringUtils.isBlank(String.valueOf(user.getOrganizationId()))){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"部门名称,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage());
		}
		if(StringUtils.isBlank(roleId)){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"角色名称,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		if(StringUtils.isBlank(user.getName())){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"用户名,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		if(StringUtils.isBlank(user.getUsername())){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"账户,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		if(StringUtils.isBlank(user.getEmail())){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"邮箱,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		if(StringUtils.isBlank(user.getMobile())){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"手机号,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		User userSelect = userDao.findByUsername(user.getUsername());
		if (userSelect != null && params.get("flag").equals("add")) {
			return ServiceResult.returnResult(ServiceResultEnum.USERID_ISEXIST.getTypeId(), ServiceResultEnum.USERID_ISEXIST.getMessage());
		}
		
		user.setRoleIds(roleId);
		if("add".equals(flag)){
			//初始化密码
			user.setPassword(CommonCode.DEFAULT_PWD);
			userDao.createUser(user);
		}
		if("update".equals(flag)){
			userDao.updateUser(user);
		}
        serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
        		ServiceResultEnum.SUCCESS.getMessage(),null);
        return serRet;
    }
    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }
    @Override
    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
	@Override
	public ServiceResult getUserList(Map<String, Object> params) {
		ServiceResult serRet = null;
		if(params==null){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),
					ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		List<User> list = userDao.selectUser(params);
		int total = userDao.selectUserCount(params);
		Map<String,Object> retMap = new HashMap<String,Object>();
		retMap.put("total", total);
		List<Map<String,Object>> retList = new ArrayList<Map<String,Object>>();
		Map<String,Object> temp = null;
		for(User user: list){
			temp  = user.getTransMap();
			retList.add(temp);
		}
		retMap.put("rows", retList);
		serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
				ServiceResultEnum.SUCCESS.getMessage(),retMap);
		return serRet;
	}
	@Override
	public ServiceResult updateStatus(String userId, String status) {
		ServiceResult serRet=null;
    	
    	//参数校验
		if(StringUtils.isBlank(userId) || StringUtils.isBlank(status)){
			return ServiceResult.returnResult(ServiceResultEnum.REQUEST_PARAM_ERROR.getTypeId(),"用户名或/状态,"+ServiceResultEnum.REQUEST_PARAM_ERROR.getMessage(),null);
		}
		User user = new User();
		user.setUsername(userId);
		user.setStatus(Integer.parseInt(status));
		if(1==Integer.parseInt(status)){
			user.setLocked(true);
		}else{
			user.setLocked(false);
		}
		try{
			userDao.updateStatus(user);
		}catch(Exception e){
			serRet = ServiceResult.returnResult(ServiceResultEnum.DB_ERROR.getTypeId(),
	        		ServiceResultEnum.DB_ERROR.getMessage(),null);
			return serRet;
		}
        serRet = ServiceResult.returnResult(ServiceResultEnum.SUCCESS.getTypeId(),
        		ServiceResultEnum.SUCCESS.getMessage(),null);
        return serRet;
	}

}
