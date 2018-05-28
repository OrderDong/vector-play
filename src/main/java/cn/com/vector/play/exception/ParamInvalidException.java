package cn.com.vector.play.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 参数异常类
 * 方法的参数校验出错时抛出该异常
 * 
 * @author mahaike
 *
 */
@Getter
@Setter
@ToString
public class ParamInvalidException extends RuntimeException {
	private static final long serialVersionUID = -5270733164140976673L;
	
	/**
	 * 字段名
	 */
	private String fieldName;
	
	/**
	 * 错误信息
	 */
	private String errorInfo;

	/**
	 * 
	 * @param fieldName 字段名
	 * @param errorInfo 错误信息
	 */
	public ParamInvalidException(String fieldName, String errorInfo) {
		super(fieldName + " " + errorInfo);
		this.fieldName = fieldName;
		this.errorInfo = errorInfo;
	}
}
