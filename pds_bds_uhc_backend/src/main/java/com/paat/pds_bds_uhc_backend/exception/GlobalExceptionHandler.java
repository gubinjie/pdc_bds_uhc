package com.paat.pds_bds_uhc_backend.exception;

import com.paat.pds_bds_uhc_backend.common.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年04月07日
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SessionExpiredException.class)
    public ResponseResult SessionExpiredHandler(HttpServletRequest rs, SessionExpiredException e) {
        return ResponseResult.error();
    }
}
