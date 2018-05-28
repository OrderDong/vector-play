package cn.com.vector.play.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.vector.play.entity.User;
import cn.com.vector.play.response.RestResponseCode;
import cn.com.vector.play.response.RestResultModel;
import cn.com.vector.play.service.UserService;
import cn.com.vector.play.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author OrderDong
 * @since 20170521
 * @description 用户控制器实现/rest接口
 *
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

	/*
	 *状态用户修改
	 */
	@RequestMapping("/editStatus")
	@ResponseBody
	public RestResultModel editStatus(HttpServletRequest request,String str) {
//		str = "{\"userId\":\"lwd_test\",\"status\":0}";
		if(StringUtils.isBlank(str)){
			return new RestResultModel(RestResponseCode.REQUEST_PARAM_ERROR,"请求参数为空！"+RestResponseCode.REQUEST_PARAM_ERROR,"");
		} 
		Map<String,Object> paMap= JSON.parseObject(str);
		String userId = (String)paMap.get("userId");
		String status = String.valueOf(paMap.get("status"));
		if(StringUtils.isBlank(userId) || StringUtils.isBlank(status)){
			return new RestResultModel(RestResponseCode.REQUEST_PARAM_ERROR,"请求参数为空！"+RestResponseCode.REQUEST_PARAM_ERROR,"");
		}
		ServiceResult result = userService.updateStatus(userId,status);
		if(ServiceResult.isSuccess(result)){
			return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC, "");
		}else{
			return new RestResultModel(RestResponseCode.FAILED, RestResponseCode.FAILED_DESC, "");
		}
	}
	
    @RequestMapping(value = "/selectUser", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public RestResultModel userManger(String userId,  String userName, String userStatus
			, String deptId, String roleId, String page, String limit)
			throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId",StringUtils.isBlank(userId)?"":userId);
		params.put("userName",StringUtils.isBlank(userName)?"":userName);
		params.put("deptId",StringUtils.isBlank(deptId)?"":deptId);
		params.put("userStatus",StringUtils.isBlank(userStatus)?null:Integer.parseInt(userStatus));
		params.put("roleId",StringUtils.isBlank(roleId)?"":roleId);
		params.put("startNum", (Integer.parseInt(page)-1)*Integer.parseInt(limit));
		params.put("limit", Integer.parseInt(limit));
		ServiceResult base =userService.getUserList(params);
		if(ServiceResult.isSuccess(base)){
			return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC, base.getResult());
		}else{
			return new RestResultModel(RestResponseCode.FAILED, RestResponseCode.FAILED_DESC, base.getMessage());
		}
	}
    
    /**
	 * 添加／修改用户,并角色授权
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addUser", method = { RequestMethod.GET ,RequestMethod.POST})
	@ResponseBody
	public RestResultModel addUser(User userin, String roleId, String flag, HttpServletRequest request)
			throws Exception {
		//组装入参
		Map<String,Object> paramMap = new HashMap();
		User user = new User();
		user.setName(request.getParameter("userName"));
		user.setUsername(request.getParameter("userId"));
		user.setMobile(request.getParameter("mobile"));
		user.setEmail(request.getParameter("email"));
		String deptid = request.getParameter("deptid");
		if(!StringUtils.isBlank(deptid)){
			user.setOrganizationId(Long.valueOf(deptid));
		}
		paramMap.put("user",user);
		paramMap.put("roleId",roleId);
		paramMap.put("flag",flag);
		ServiceResult base =userService.createUser(paramMap);
		if(ServiceResult.isSuccess(base)){
			return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC, base.getResult());
		}else{
			return new RestResultModel(RestResponseCode.FAILED, RestResponseCode.FAILED_DESC, base.getMessage());
		}
	}

   /* @RequiresPermissions("user:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "user/list";
    }*/

    /*@RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("op", "新增");
        return "user/edit";
    }*/
	
}
