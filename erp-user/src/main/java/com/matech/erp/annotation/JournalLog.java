package com.matech.erp.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JournalLog {
    /** 要执行的操作类型比如：add **/
    public String operationType() default "";
    /** 要执行的模块名称如：Carouse **/
    public String modularTypeName() default "";
}