package cn.com.vector.play.dao;

import cn.com.vector.play.entity.User;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户DAO定义
 *
 */
public interface UserDao {

    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);
    User findOne(Long userId);
    List<User> findAll();
    User findByUsername(String username);
    List<User> selectUser(Map<String, Object> params);
    int selectUserCount(Map<String, Object> params);
	public void updateStatus(User user);
}
