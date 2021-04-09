package com.paat.pds_bds_uhc_backend.common.result;

import com.paat.pds_bds_uhc_backend.common.support.StatusEnum;

import java.io.Serializable;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年04月07日
 */
public class ResponseResult<T> implements Serializable {

    private String code;
    private String msg;
    private T result;

    public ResponseResult(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult<>(StatusEnum.FAILURE.getCode(), StatusEnum.FAILURE.getMessage());
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
