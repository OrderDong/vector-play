package cn.com.vector.play.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author OrderDong
 * @since 20170525
 * @description rest响应对象
 */
@Getter
@Setter
@AllArgsConstructor
public class RestResultModel {
    /**
     * 响应码(1成功)
     */
    private String status;
    /**
     * 返回说明
     */
    private String message;
    /**
     * 返回数据
     */
    private Object result;
    
}
