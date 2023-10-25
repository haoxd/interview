

#### Spring AOP 的底层实现
 
-   AOP 是IOC的拓展功能 ,AOP代理只是IOC创建过程当中的一个拓展点 拓展出在 beanPostProcessor 这个接口的前置执行和后置执行


-   在BeanPostProcessor的后置处理方法当中执行


-  通过jdk或者cglib的方式生成代理对象

-  在执行方法的调用的时候。会调用到生成的字节码文件，调用dynamicAdvisoredIntercrptor类中的intercept方法
    从这个方法开始执行
    
-  更具之前定义好的通知生成拦截器链


-  从拦截器链中依次获取每一个通知开始执行，在执行的过程当中，为了方便找到下一个通知，
    会有一个cglibMethodInvocation的对象，找的时候从-1的位置开始查找执行   