package com.example.skeleton.config.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yebing
 */
@Aspect
@Component
public class ControllerIntercept {

    /**
     * 配置切入点
     */
    @Pointcut(value = "execution (* com.example.skeleton.controller..*.*(..))")
    public void aopPointCut() {
        System.out.println("进入pointcut！");
    }

    /**
     * 环切操作
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "aopPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("环切操作！！！！！");
        Object proceed = null;
        try {
            Class<?> aClass = joinPoint.getTarget().getClass();
            /* 方法 */
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            ControllerInterceptAnnotation aopAnnotation = method.getAnnotation(ControllerInterceptAnnotation.class);
            if (aopAnnotation != null) {
                Map<String, Object> map = new HashMap<>(16);
                /*参数名*/
                String[] parameterNames = signature.getParameterNames();
                /* 参数值 */
                Object[] args = joinPoint.getArgs();
                String kind = joinPoint.getKind();
                System.out.println("kind:" + kind);
                /*注入map*/
                for (int i = 0; i < args.length; i++) {
                    map.put(parameterNames[i], args[i]);
                }
                System.out.println("signature:" + JSONObject.toJSONString(signature));
                System.out.println("map:" + JSONObject.toJSONString(map));
            }

            /* 异常获取当前线程栈 */
            StackTraceElement[] throwableStackTrace = new Throwable().getStackTrace();
            for (StackTraceElement stackTraceElement : throwableStackTrace) {
            }

            /* 当前线程获取线程栈 */
            StackTraceElement[] threadStackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : threadStackTrace) {
            }
            /*执行被切方法*/
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    public static void main(String[] args) {
        Tel tel = new Tel();
        tel.start();
        int[] is = {0,5,2,3,6,1,4,7,9,8};
        for(int i=0;i<is.length;i++){
            for (int j=i;j<is.length;j++){
                if(is[i] < is[j]){
                    int tmp = is[i];
                    is[i] = is[j];
                    is[j] = tmp;
                }
            }
        }
        for (int i : is) {
            System.out.print(i +"   ");
        }
    }

    public static class Tel extends Thread{
        @Override
        public void run() {
            System.out.println("I am thread");
            super.run();
        }
    }
}

