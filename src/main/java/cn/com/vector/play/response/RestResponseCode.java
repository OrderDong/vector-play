package cn.com.vector.play.response;

/**
 * @author OrderDong
 * @since 20170525
 * @description rest响应CODE配置
 */
public interface RestResponseCode {
	//请求处理成功
	public static final String SUCCESS = "0";
	public static final String SUCCESS_DESC = "success";
	//请求处理失败
	public static final String FAILED = "1";
	public static final String FAILED_DESC = "failed";
	//参数错误
	public static final String PARAMETER_ERROR = "499";
	public static final String PARAMETER_ERROR_DESC = "参数异常,请重试!";
	//内部错误
	public static final String INTERNAL_ERROR = "500";
	public static final String INTERNAL_ERROR_DESC = "内部发生错误,请联系管理员!";
	//验证码错误
	public static final String IMAGECODE_ERROR ="-102";
	public static final String IMAGECODE_ERROR_DESC = "图片验证码错误";
	//登录名或密码错误
	public static final String SERVICE_LONGIN_ERROR ="-101";
	public static final String SERVICE_LONGIN_ERROR_DESC = "登录名或密码错误";
	//该用户不存在或已禁用
	public static final String LONGIN_NOTFOUND_ERROR ="-104";
	public static final String LONGIN_NOTFOUND_ERROR_DESC = "该用户不存在或已禁用";
	//传入参数错误
	public static final String REQUEST_PARAM_ERROR ="-1";
	public static final String REQUEST_PARAM_ERROR_DESC = "传入参数错误";
	//请求处理失败
	public static final String NO_PERMISSION = "10";
	public static final String NO_PERMISSION_DESC = "未授权";
	
	//未登录
	public static final String NO_Login = "9";
	public static final String NO_Login_DESC = "未登录";
	
	
	
}
