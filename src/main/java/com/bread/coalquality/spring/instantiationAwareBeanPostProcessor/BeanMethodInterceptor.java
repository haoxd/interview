package com.bread.coalquality.spring.instantiationAwareBeanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class BeanMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("目标方法前:" + method + "\n");
        Object object = methodProxy.invokeSuper(o, objects);
        log.info("目标方法后:" + method + "\n");
        return object;
    }
}

