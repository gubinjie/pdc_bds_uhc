package com.paat.pds_bds_uhc_backend.exception;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年04月07日
 */
public class SessionExpiredException extends Exception {
    private int code;
    private String msg;

    public SessionExpiredException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
