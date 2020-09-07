package com.rain.common;

public enum ResultCode implements IErrorCode{
    SUCCESS("200","操作成功"),
    FAILED("500","操作失败"),
    FORBIDDEN("403","没有权限");


    private String code;
    private String message;

    private ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
