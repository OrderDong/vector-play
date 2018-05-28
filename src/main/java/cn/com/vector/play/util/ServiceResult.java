package cn.com.vector.play.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.vector.play.exception.EngineRuntimeException;


/**
 * @author OrderDong
 * @since 20170525
 * @description 统一服务返回处理类
 */
public class ServiceResult implements Serializable{
	
	private static final String SPLITTAG_STRING = ",";
	
	private String status;
	private String message;
    private Object result;
    private Map<String,Object> otherInfo= new HashMap<String,Object>();
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Map<String, Object> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(Map<String, Object> otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public static ServiceResult build(ServiceResultEnum resultCode){
		ServiceResult baseResult = new ServiceResult();
        baseResult.setStatus(resultCode.getTypeId());
        baseResult.setMessage(resultCode.getMessage());
        return baseResult;
    }

   
    /**
     * 存入顺序必须是 status message result otherInfo
     * @param params
     * @return
     * @throws EngineRuntimeException
     */
	public static ServiceResult returnResult(Object... params) throws EngineRuntimeException {
		ServiceResult baseReuslt = new ServiceResult();
		
		if (params != null && params.length > 0) {
			StringBuilder stringBuilder = new StringBuilder(SPLITTAG_STRING);
			for(int i=0;i<params.length;i++){
				Object objectParam=params[i];
				if(i==0){
					if(objectParam instanceof String){
						baseReuslt.setStatus(objectParam.toString());
					}else{
						throw new EngineRuntimeException("status属性不合法");
					}
				}
				if(i==1){
					if(objectParam instanceof String){
						baseReuslt.setMessage(objectParam.toString());
					}else{
						throw new EngineRuntimeException("message属性不合法");
					}
				}
				if(i==2){
					baseReuslt.setResult(objectParam);
				}
				if(i==3){
					if(objectParam instanceof Map){
						Map<String,Object> tempMap =(Map<String, Object>) objectParam;
						baseReuslt.setOtherInfo(tempMap);
					}else{
						throw new EngineRuntimeException("otherInfo属性不合法");
					}
				}
			}
            
		}
		return baseReuslt;
		
	}
	/**
	 * 判断返回是否成功 true成功 false不成功
	 */
	public static boolean isSuccess(ServiceResult baseReuslt){
		String status =baseReuslt.getStatus();
		if(!status.equals(ServiceResultEnum.SUCCESS.getTypeId())){
			return false;
		}else{
			return true;
		}
	}
}
