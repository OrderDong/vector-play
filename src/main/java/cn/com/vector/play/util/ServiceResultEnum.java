package cn.com.vector.play.util;

/**
 * @author OrderDong
 * @since 20170525
 * @description 结果返回码表类
 */
public enum ServiceResultEnum {
    /**
     * 
     */
    TEST("10000", "这是一个测试的返回值"), 
    RESERVED_END("9999", "保留code段结束"),
    SUCCESS("0","调用成功"),
    REQUEST_PARAM_ERROR("-1","传入参数错误"),
    NOI_MPL_CLASS("-2","无此服务接口实现类"),
    INSIDE_ERROR("-3","服务内部错误"),
    RETURN_EMPTY("-4","服务返回为空"),
    OBJECT_EXITS("-6","对象已存在"),
    CLASS_TRANSFER_ERROR("-5","接口实现类转换错误"),
    CALLSERVER_ERROR("-7","调用服务失败"),
    SERVICE_GENERAL_ERROR("-8","服务通用错误"),
    SERVICE_LONGIN_ERROR("-101","登录名或密码错误"),
    IMAGECODE_ERROR("-102","图片验证码错误"),
    SERVICE_LONGIN_USER_NOTFOUND("-104","该用户不存在或已禁用"),
    SERVICE_LONGIN_USER_DISABLED("-103", " 该用户已禁用,请联系管理员"),
    DB_ERROR("-9", "数据库操作失败,请稍后重试"),
    PARAM_ILLEGAL_CHARACTER("-10", "参数中包含非法字符"),
    USERID_ISEXIST("9999", "保留code段结束");
    
    
    private ServiceResultEnum(String typeId, String message) {
        this.typeId = typeId;
        this.message = message;
    }

    private String message;

    private String typeId;

    private String clientMessage;

    private ServiceResultEnum(String typeId, String message, String clientMessage) {

        this.typeId = typeId;
        this.message = message;
        this.clientMessage = clientMessage;
    }

    @Override
    public String toString() {
        return typeId + ":::" + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }


    public static void main(String[] args) {
//        System.out.println(ResultCodeEnum.getMessage(FAIL.typeId));
    }

    public String getClientMessage() {
        return clientMessage; 
    }

}
