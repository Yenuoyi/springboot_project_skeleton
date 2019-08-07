package com.example.skeleton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yebing
 */
@EnableTransactionManagement
@MapperScan("com.example.skeleton.dao")
@SpringBootApplication
@EnableScheduling
/** 使用@Webfilter必须加@ServletComponentScan*/
@ServletComponentScan
public class SkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }

}
