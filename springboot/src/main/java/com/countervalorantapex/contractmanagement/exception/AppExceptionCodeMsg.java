package com.countervalorantapex.contractmanagement.exception;

//这个枚举类中定义的都是跟业务有关的异常
public enum AppExceptionCodeMsg {
    INSUFFICIENT_PRIVILEGES(401,"无token或token验证失败，权限不足"),

    USER_NOT_EXISTS(402,"用户不存在或密码错误"),
    FILE_NO_EXISTS(601,"文件不存在")
    ;

    private int code ;
    private String msg ;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    AppExceptionCodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
