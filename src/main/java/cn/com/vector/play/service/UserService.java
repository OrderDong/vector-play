package cn.com.vector.play.service;

import cn.com.vector.play.entity.User;
import cn.com.vector.play.util.ServiceResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户服务接口定义
 *
 */
public interface UserService {

    public ServiceResult createUser(Map<String, Object> params);
    public void deleteUser(Long userId);
    User findOne(Long userId);
    List<User> findAll();
    public ServiceResult getUserList(Map<String, Object> params);
	public ServiceResult updateStatus(String userId, String status);

}
