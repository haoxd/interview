

#### Spring BeanFactory 和 FactoryBean的区别
 
-  俩个都是用来创建bean对象

- 使用BeanFactory 创建bean的时候，必须严格执行spring 创建的生命周期，如果我们要简单的定义一些对象，在创建完成的时候交给spring进行管理
    我们就可以实现factoryBean接口或者继承AbstractFactoryBean
    
    由三个方法
    getObject
    getObjectType
    isSingleton