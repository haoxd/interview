

#### Spring的事务是如何回滚的，Spring事务管理是如何实现的
 
-  spring的事务 是由AOP实现的，首先 生成具体的代理对象  然后按照aop的流程来执行具体的操作逻辑

，如果按照AOP的执行流程来实现， 需要通过通知来完成核心功能，但是spring的事务并不是通过通知实现的，而是通过

TransactionInterceptor来实现的 ，调用其invoke方法来实现具体业务逻辑

- 先做准备工作，解析各个方法 上的事务注解属性，更具具体的属性配置来判断是否开启新事务


- 当需要开启新事务的时候，获取数据库连接，关闭自动提交功能，开启事务

- 执行具体的业务逻辑

- 在执行过程当中，如果执行失败，则通过completeTransactionAfterThrowing 来完成回滚的，具体的回滚实现方法逻辑
    通过doRollBack方法来实现的，实现的时候 也是要先获取数据库连接，底层其实调用的就是conn的rollback方法

- 如果执行过程当中，没异常发送，则通过completeTransactionAfterReturning 来完成提交，具体的提交方法逻辑同通过
   doCommit方法来实现的，实现的时候也是先获取数据库连接，底层业务调用的conn的commit方法来执行提交  
  
- 当事务执行完成之后，清除相关的事务信息，调用 cleanupTransaction方法