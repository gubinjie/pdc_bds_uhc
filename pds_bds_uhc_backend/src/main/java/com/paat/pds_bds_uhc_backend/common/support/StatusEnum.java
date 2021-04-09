package com.paat.pds_bds_uhc_backend.common.support;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年04月07日
 */
public enum StatusEnum {
    /**
     *
     */
    SUCCESS("200", "请求成功"),
    FAILURE("400", "请求失败");

    private String code;
    private String message;

    StatusEnum(String code, String message) {
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
