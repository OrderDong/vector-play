package cn.com.vector.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.com.vector.SpringUtil;
import cn.com.vector.play.entity.User;
import cn.com.vector.play.service.UserService;
import cn.com.vector.play.util.ServiceResult;


public class UserServiceTest {
	UserService userService = SpringUtil.userService;
	/*@Test
	public void selectUserTest(){
		User user = userService.selectUser(UUID.randomUUID().toString().replaceAll("-", ""),1);
		System.out.println(user);
	}
	@Test
	public void selectAllTest(){
		List<User> list = userService.selectAll(UUID.randomUUID().toString().replaceAll("-", ""));
		for (User user : list) {
			System.out.println(user);
		}
	}*/
	@Test
	public void selectUserTest(){
		/*Set<String> permissions = new HashSet<String>();
		permissions.add("user:*");
		permissions.add("resource:*");*/
		/*
		Set<String> users = userService.findPermissions("admin");
		List<Map<String,Object>> menus  = resourceService.findMenus(users);*/
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId","");
		params.put("userName","");
		params.put("deptId","");
		params.put("userStatus",1);
		params.put("roleId","");
		params.put("startNum",0);
		params.put("limit", 1);
		ServiceResult menus  = userService.getUserList(params);
		System.out.println(JSON.toJSON(menus));
		/*
		ServiceResult base =userService.resetPassword("lwd_test");
		System.out.println("=======================");*/
//		System.out.println(menus);
	}
	@Test
	public void createUserTest(){
		Map<String,Object> paramMap = new HashMap();
		User user = new User();
		user.setName("刘伟东");
		user.setUsername("liuweidong");
		user.setMobile("12345678912");
		user.setEmail("12345678912@qq.com");
		String deptid = "3";
		user.setOrganizationId(Long.valueOf(deptid));
		paramMap.put("user",user);
		paramMap.put("roleId","1");
		paramMap.put("flag","add");
		ServiceResult base =userService.createUser(paramMap);
		/*Set<String> permissions = new HashSet<String>();
		permissions.add("user:*");
		permissions.add("resource:*");*/
		
		/*ServiceResult users = roleService.searchRole("all", "");
		System.out.println("=======================");
		System.out.println(users.getResult().toString());*/
		/*ServiceResult users = roleService.searchRole("all", "");*/
		/*
		String str = "[{\"moduleId\":\"3\"},{\"moduleId\":\"8\"},{\"moduleId\":\"9\"}]";
		ServiceResult users =roleService.roleAuth("2", str, "lwd");
		System.out.println("========"+users.getMessage());*/
	}
}
