package com.example.skeleton.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author yebing
 */
@Component
public class SpringUtil {
    private static ConfigurableListableBeanFactory configurableListableBeanFactory;

    public SpringUtil(ConfigurableListableBeanFactory configurableListableBeanFactory){
        configurableListableBeanFactory = configurableListableBeanFactory;
    }

    public Object getBean(String beanName){
        Object bean = configurableListableBeanFactory.getBean(beanName);
        return bean;
    }
}
