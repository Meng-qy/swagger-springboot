package com.meng.utils;

import java.io.Serializable;

public class ReturnResult <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long code;
    private T data;
    private String msg;

    public ReturnResult() {
        this.code=ResultCode.SUCCESS.getCode();
        this.msg=ResultCode.SUCCESS.getMessage();
    }

    /**
     * @param code
     * @param msg
     * @param data
     */

    public ReturnResult(long code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 返回 code 和 data
     * @param data
     */
    public ReturnResult(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.data = data;
    }

    /**
     * 返回 code 和 msg
     * @param code
     * @param msg
     */
    public ReturnResult(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public ReturnResult Msg(String msg){
        this.setMsg(msg);
        return this;
    }


    public ReturnResult Code(long code){
        this.setCode(code);
        return this;
    }


    public ReturnResult Data(T data){
        this.setData(data);
        return this;
    }

    /**
     * 返回默认状态
     */
    public static <T> ReturnResult<T> successed() {
        return new ReturnResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    /**
     * 成功返回
     *
     * @param data
     * @return
     */
    public static <T> ReturnResult<T> successed(T data) {
        return new ReturnResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> ReturnResult<T> failed(IErrorCode errorCode) {
        return new ReturnResult(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 返回失败状态
     *
     * @param msg
     * @return
     */
    public static <T> ReturnResult<T> failed(String msg) {
        return failed(ResultCode.FAILED);
    }


    /**
     * 参数验证失败
     *
     * @param <T>
     * @return
     */
    public static <T> ReturnResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败，返回信息
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ReturnResult<T> validateFailed(String msg) {
        return new ReturnResult<>(ResultCode.VALIDATE_FAILED.getCode(), msg);
    }

    /**
     * 未登录返回结果 。 token过期..
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ReturnResult<T> unauthorized(T data) {
        return new ReturnResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ReturnResult<T> forbiden(T data) {
        return new ReturnResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}