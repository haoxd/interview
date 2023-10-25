

#### Spring IOC的理解，原理和实现
 
-  控制反转  IoC
        
        {
               IoC也称为依赖注入(DI)。
               它是一个过程，对象
                   1 通过有参构造函数、
                   2 工厂方法参数
                   3 对象实例构造
                   4 从工厂方法返回后调用其setter方法设置依赖项
                   容器在创建bean时注入这些依赖项。
               这个过程基本上是bean本身的反向(因此得名，控制反转)，它通过直接构造类或类似服务定位器模式的机制来控制其依赖项的实例化或位置。
            
            涉及的点 @Autowired，@populateBen 完成属性值的注入
        }

-  容器

        {
             存放 spring bean的容器，底层存放在三级缓存当中，数据结构是map
                
                 *1，singletonObjects 一级缓存 ： 缓存单例bean的名称和示例对象 ,存放已经经历了完整生命周期的bean对象
                 *2，earlySingletonObjects 二级缓存： 存放早期暴露出来的bean对象，bean的生命周期未结束（属性还没有填充完）
                 *3，singletonFactories 三级缓存： 存放可以生成的bean工厂
             
             整个bean的生命周期从创建到销毁都是由spring 容器进行管理的
        
        }
        
- 容器的创建过程


        {
                1 容器创建的核心接口 
                    beanFactory是spring ioc的底层核心接口，提供了获取bean（getBean），是否单例bean的一些
                    defaultListableBeanFactory 
                ，在创建的过程当中优先想bean工厂当中设置一些参数
                    例如 BeanPostProcessor，Aware接口的一些字类
        
                2 加载解析bean对象 ，准备要创建的bean的定义信息BeanDefinition，设置到xml，注解的解析过程
                
                3 beanFactoryPostProcessor的扩展，此处是拓展点，最常见的例如，placeHolderConfigurSupport（占位符处理）
                   ConfigurationClassPostProcessor
                
                4 beanPostProcessor的注册功能，方便后续对bean对象完成具体的拓展功能
        
        
                5 通过反射的方式将 BeanDefinition实例化位具体的bean对象
        
        
                6 bean对象的初始化，填充属性，调用Awarea字类方法，调用beanPostProcessor前置处理方法，调用init-method方法，
                调用beanPostProcessor的后置处理方法
                
                7 生成完整的bean对象，通过getbean方法可以直接获取到
                
                8 调用distroy方法进行销毁
                
                
                
        }
