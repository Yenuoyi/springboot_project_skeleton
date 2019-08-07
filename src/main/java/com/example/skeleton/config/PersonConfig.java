package com.example.skeleton.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录人实体，用作请求接口校验
 * @author yebing
 */

@Configuration
@ConfigurationProperties(prefix = "system.login")
public class PersonConfig {
    /**
     * data.person.name
     * 这里map名需要和application.properties中的参数一致
     */
    private Map<String, String> person = new HashMap<>();


    public Map<String, String> getPerson() {
        return person;
    }

    public void setPerson(Map<String, String> person) {
        this.person = person;
    }
}
