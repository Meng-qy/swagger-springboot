package com.meng.utils;

public enum  ResultCode implements IErrorCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILED(404,"参数检验失败"),
    UNAUTHORIZED(401,"暂未登陆或相关token已经过期"),
    FORBIDDEN(403,"没有相关权限"),


    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");
    private long code;
    private String msg;

    ResultCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

interface IErrorCode {
    long getCode();

    String getMessage();
}
