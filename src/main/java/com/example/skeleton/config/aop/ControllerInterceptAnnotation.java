package com.example.skeleton.config.aop;

import java.lang.annotation.*;

/**
 * 控制器拦截注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface ControllerInterceptAnnotation {
}
