package com.bread.coalquality.spring.beanFactoryPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 这个接口是beanFactory的扩展接口，调用时机在spring在读取beanDefinition信息之后，实例化bean之前。
 * 在这个时机，用户可以通过实现这个扩展接口来自行处理一些东西，比如修改已经注册的beanDefinition的元信息。
 * */
@Configuration
@Slf4j
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        log.info("start spring-------》BeanFactoryPostProcessor 拓展点");

        BeanDefinition user = beanFactory.getBeanDefinition("user");
        MutablePropertyValues propertyValues = user.getPropertyValues();
        propertyValues.forEach(propertyValue -> {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            log.info(name+":"+value);

            if(StringUtils.equals(name,"userName")){
                propertyValues.add("userName","哈哈哈");
            }
        });

        log.info("end spring-------》BeanFactoryPostProcessor 拓展点");

    }
}