package com.example.skeleton.config.aop;

import com.example.skeleton.common.datasource.DataSourceEnum;

import java.lang.annotation.*;

/**
 * 控制器拦截注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface SelectDataSource {
    DataSourceEnum dataSourceName() default DataSourceEnum.MASTER_DATASOURCE;
}
