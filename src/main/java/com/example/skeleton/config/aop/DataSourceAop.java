package com.example.skeleton.config.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.skeleton.common.datasource.DataSourceEnum;
import com.example.skeleton.common.datasource.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yebing
 */
@Aspect
@Component
public class DataSourceAop {
    @Value("${spring.datasource.master.name}")
    private String masterName;

    @Value("${spring.datasource.slave.name}")
    private String slaveName;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 配置切入点
     */
    @Pointcut(value = "@annotation(com.example.skeleton.config.aop.SelectDataSource)")
    public void dataSourcePointCut() {
        System.out.println("into Select Datasource pointcut！");
    }

    @Before("dataSourcePointCut()")
    public void before(JoinPoint joinPoint) {
        Class<?> aClass = joinPoint.getTarget().getClass();
        SelectDataSource selectDataSource =  aClass.getAnnotation(SelectDataSource.class);
        if(selectDataSource != null){
            DataSourceEnum dataSource = selectDataSource.dataSourceName();
            logger.info("This is datasource："+dataSource);
            DynamicDataSource.putDataSourceKey(dataSource.getName());
        }else{
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            SelectDataSource methodAnnotation = method.getAnnotation(SelectDataSource.class);
            if(methodAnnotation != null){
                DataSourceEnum dataSource = selectDataSource.dataSourceName();
                logger.info("This is datasource："+dataSource);
                DynamicDataSource.putDataSourceKey(dataSource.getName());
            }

        }
    }

    /**
     * 执行完切面后，将线程共享中的数据源名称清空
     * @param joinPoint
     */
    @After("dataSourcePointCut()")
    public void after(JoinPoint joinPoint){
        logger.info("执行完毕！");
        DynamicDataSource.removeDataSourceKey();
    }

    public static void main(String[] args) {
        System.out.print(DtaSourceEnum.MASTER_DATASOURCE.name());
        System.out.print(DtaSourceEnum.MASTER_DATASOURCE.getNameStr());

    }

    enum DtaSourceEnum {
        MASTER_DATASOURCE("masterDatasource"),
        SLAVE_DATASOURCE("slaveDatasource");

        DtaSourceEnum(String nameStr){
            this.nameStr = nameStr;
        }
        private String nameStr;

        public String getNameStr() {
            return nameStr;
        }

        public void setName(String name) {
            this.nameStr = name;
        }
    }

}
