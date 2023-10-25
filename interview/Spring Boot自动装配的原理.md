

#### Spring Boot自动装配的原理
 
-  在spring boot的启动过程当中第一步是创建Spring 上下文  核心的类是

- @SpringBootApplication 核心注解

        {
            1 @SpringBootConfiguration
            
                SpringBootConfiguration其实就携带了一个@Configuration注解，这个注解我们再熟悉不过了，他就代表自己是一个Spring的配置类
                
                
            2 @EnableAutoConfiguration
            
                    注解和自动配置相关，点进去看源代码之后可以发现，其内部就包含了这么两个注解。
                    
                    @AutoConfigurationPackage //自动配置包
                    
                    @Import(AutoConfigurationImportSelector.class)//自动配置导入选择
                    
                    最主要的就是这个AutoConfigurationImportSelector类
                        里面的核心方法 getCandidateConfigurations() 这个方法可以用来获取所有候选的配置，那么这些候选的配置又是从哪来的呢？
                        
                         这个方法返回了List<String> 这个list 是由SpringFactoriesLoader.loadFactoryNames
                         这个方法去找存放在mate-info下的spring.practories 文件当中的配置
                         将其加载到springIOC容器当中
        
        }