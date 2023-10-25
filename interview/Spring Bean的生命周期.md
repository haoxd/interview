

#### Spring Bean的生命周期
 
-  实例化bean 使用反射生成对象

-  使用populateBean 进行的bean的属性填充 ，此处会产生循环依赖的问题，使用三级缓存来解决

-  调用Aware接口相关的方法 ，invokeAwareMethod（执行Aware方法），完成beanName,beanFactory，beanClassLoader对象属性的设置

-  调用beanPostProcessor中的前置处理器，例如 ApplicationContextPostProcessor 设置了 ApplicationContext,Environment,ResourceLoader等对象

-  检查bean是否实现了InitializingBean接口 判断是否执行 afterPropertiesSet方法 进行属性填充设置

-  调用BeanPostProcessor后置处理方法 ，spring 的AOP就是在此处实现的（AbstractAutoProxyCreator），springCloud openfeign 接口的注册，hsf接口注册在注册中心都是在此处执行的
    

- 然后可以通过getBean方法获取到完整的bean对象

- 销毁流程
    
        {
                1 判断是否实现了dispoAbleBean 接口
                2 执行distory方法
        }
