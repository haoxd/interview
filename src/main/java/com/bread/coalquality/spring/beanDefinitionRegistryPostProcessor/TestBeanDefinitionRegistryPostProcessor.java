package com.bread.coalquality.spring.beanDefinitionRegistryPostProcessor;

import com.bread.coalquality.mvc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * 这个接口在读取项目中的beanDefinition之后执行，提供一个补充的扩展点
 * 使用场景：你可以在这里动态注册自己的beanDefinition，可以加载classpath之外的bean
 */
@Configuration
@Slf4j
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor ,PriorityOrdered{


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {



        BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.add("userName","张三").add("passWord","11111").add("id",1234L);


        registry.registerBeanDefinition("user", beanDefinition);

        log.info("进入spring-------》BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry 拓展点");

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("进入spring-------》BeanDefinitionRegistryPostProcessor#postProcessBeanFactory 拓展点");


    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE-1;
    }
}