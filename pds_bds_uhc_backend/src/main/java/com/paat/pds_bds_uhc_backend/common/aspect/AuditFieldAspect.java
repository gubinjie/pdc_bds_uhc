package com.paat.pds_bds_uhc_backend.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年03月30日
 */
@Component
@Aspect
public class AuditFieldAspect {


    /** Aop切点新增的表达式 */
    private static final String AOP_POINTCUT_EXPRESSION_INSERT = "execution(* com.paat.pds_bds_uhc_backend..*.insert*(..)))";

    /** Aop切点修改的表达式 */
    private static final String AOP_POINTCUT_EXPRESSION_UPDATE = "execution(* com.paat.pds_bds_uhc_backend..*.update*(..)))";

    /** 创建人 */
    private static final String CREATOR     = "createdBy";

    /** 修改人 */
    private static final String MODIFIER    = "updatedBy";

    /** 创建时间 */
    private static final String GMTCREATE   = "createdDate";

    /** 修改时间 */
    private static final String GMTMODIFIED = "updatedDate";

    @Pointcut(AOP_POINTCUT_EXPRESSION_INSERT)
    public void insertMethods(){

    }

    @Pointcut(AOP_POINTCUT_EXPRESSION_UPDATE)
    public void updateMethods(){

    }

    @Before("insertMethods()")
    public void beforeInsert(JoinPoint jp){
        Object[] args = jp.getArgs();
        if (args != null && args.length > 0) {
            Object argument = args[0];
            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);

            if (beanWrapper.isWritableProperty("id")) {
                beanWrapper.setPropertyValue("id", UUID.randomUUID().toString().replace("-",""));
            }

            // 设置创建时间和修改时间
            if (beanWrapper.isWritableProperty(GMTCREATE)) {
                beanWrapper.setPropertyValue(GMTCREATE, LocalDateTime.now());
            }
            if (beanWrapper.isWritableProperty(GMTMODIFIED)) {
                beanWrapper.setPropertyValue(GMTMODIFIED, LocalDateTime.now());
            }
            // 设置创建人和修改人
            if (beanWrapper.isWritableProperty(CREATOR) ) {
                beanWrapper.setPropertyValue(CREATOR,"SYSTEM");
            }
            if (beanWrapper.isWritableProperty(MODIFIER)) {
                beanWrapper.setPropertyValue(MODIFIER, "SYSTEM");
            }
        }

    }
}
