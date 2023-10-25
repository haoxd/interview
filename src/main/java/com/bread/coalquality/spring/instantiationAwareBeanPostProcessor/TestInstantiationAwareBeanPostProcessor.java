package com.bread.coalquality.spring.instantiationAwareBeanPostProcessor;

import com.bread.coalquality.mvc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该接口继承了BeanPostProcess接口，区别如下：
 *
 *BeanPostProcess接口只在bean的初始化阶段进行扩展（注入spring上下文前后），
 * 而InstantiationAwareBeanPostProcessor接口在此基础上增加了3个方法，
 * 把可扩展的范围增加了实例化阶段和属性注入阶段。
 *
 *该类主要的扩展点有以下5个方法，主要在bean生命周期的两大阶段：实例化阶段 和初始化阶段 ，下面一起进行说明，按调用顺序为：
 *
 * postProcessBeforeInstantiation：实例化bean之前，相当于new这个bean之前
 * postProcessAfterInstantiation：实例化bean之后，相当于new这个bean之后
 * postProcessProperties：bean已经实例化完成，在属性注入时阶段触发，@Autowired,@Resource等注解原理基于此方法实现
 * postProcessBeforeInitialization：初始化bean之前，相当于把bean注入spring上下文之前
 * postProcessAfterInitialization：初始化bean之后，相当于把bean注入spring上下文之后
 * 使用场景：这个扩展点非常有用 ，无论是写中间件和业务中，都能利用这个特性。比如对实现了某一类接口的bean在各个生命期间进行收集，或者对某个类型的bean进行统一的设值等等。
 */
@Configuration
@Slf4j
public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public static final String BEAN_NAME="userForIoc";

    @Bean(BEAN_NAME)
    public User user(){
        User build = User.builder().userName("1111").passWord("2222").id(1234L).build();
        return  build;
    }


    /**
     * 实例化bean之前，相当于new这个bean之前
     * <p>
     * <p>
     * 当调用postProcessBeforeInstantiation返回对象时，就可以直接返回对象了，就不会走到AbstractAutowireCapableBeanFactory的doCreateBean方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        /*if (beanName.equals(BEAN_NAME)) {
            log.info("beanName:" + beanName + "执行..postProcessBeforeInstantiation");

            //利用 其 生成动态代理
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new BeanMethodInterceptor());
            User bean = (User) enhancer.create();
            log.info("返回动态代理");
            return bean;
        }*/
        return null;

    }

    /**
     * 实例化bean之后，相当于new这个bean之后
     * <p>
     * 如果返回值是false，那么就不进行下面的依赖注入流程了
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    /**
     * bean已经实例化完成，在属性注入时阶段触发，
     * Instantiation(实例化)
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {

        if (beanName.equals(BEAN_NAME)) {
            log.info("beanName:" + beanName + "执行..postProcessProperties\n");

            //修改bean中name 的属性值
            User user= (User) bean;
            log.info("修改之前 userName 的value是：" + user.getUserName() + "\n");
            user.setUserName("哈哈哈哈");
            return pvs;
        }
        return pvs;
    }


    /**
     * 初始化bean之后，相当于把bean注入spring上下文之后
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }


    /**
     * 初始化bean之前，相当于把bean注入spring上下文之前
     * Initialization(初始化)
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}