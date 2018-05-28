package cn.com.vector.play.exception;


public class EngineRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 6643482569602370581L;

    /**
     * 错误信息
     */
    String message;

    /**
     * 错误码
     */
    String code;


    public EngineRuntimeException(String errorMsg){
        this.message = errorMsg;
    }

    /**
     * 获取异常消息文本
     */
    public String getMsg() {
        return message;
    }

    /**
     * 获取异常code
     */
    public String getCode() {
        return code;
    }

    public String getLocalizedMessage() {
        return super.getMessage();
    }

}
