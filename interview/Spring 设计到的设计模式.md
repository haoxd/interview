

#### Spring 用到的设计模式
 
-  单例模式 spring的bean默认都是单例的

- 工厂模式 beanFactory

- 模板方法  postProcessorBeanFactory , onRefresh,initPropertyValue

- 策略模式  xmlBeanDefinitionReader,propertiesBeanDefinitionReader 

- 观察者模式 listener，event

- 责任链模式  chain
 
- 代理模式 动态代理

- 门面