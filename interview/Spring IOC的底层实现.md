

#### Spring IOC的底层实现

-  bean的创建依赖于反射

- 工厂 beanFactory

- 设计模式

- 关键的方法


        {
          1 createBeanFactory 
          
          2 getBean
          
          3 doGetBean
          
          4 createBean
          
          5 doCreateBean
          
          6 createBeaninstance（getDeclaredConstructor,newInstance）
          
          7 populateBean
        
          8 initializBean
        
        }
        
        1 使用createBeanFactory创建bean工厂，（defaultListablebeanFactory）
        
        2 由于spring 的bean默认都是单例的，所以优先使用 getbean 和doGetBean方法进行查找
        
        3 如果查找不到 通过 createBean 和doCreateBean方法，已反射方式进行创建，一般情况使用无参构造方法（getDeclaredConstructor,newInstance）
        
        4 然后使用populateBean进行bean的属性填充
        
        5 在调用 initializBean 进行其他初始化操作 