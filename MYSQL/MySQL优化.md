

#### mysql-cpu 高解决思路
 
- 1 使用top 命令查看mysqld进程的cpu使用率
        
            {
                1 切换到当前使用数据库
                2 使用 show full processlist;命令查看当前会话
                3 观察是那些sql导致的消耗的资源，重点观察state指标
                4 定位到具体sql                      
            }

- 2 pidstat 

            {
                1 定位到线程
                2 在PERFORMANCE_SCHEMA THREADS中记录了thread_os_id 找到线程执行的sql
                3 根据操作系统id可以找到processlist 表当中执行的会话
                4 在会话当中找到具体sql
            }
            
            
            
######## 超大分页如何优化

- 1 如果主键自增可以 select name from user where id >10000 Limit 10;
- 2 延迟关联
        
        {
            在阿里巴巴《ava开发手册》中的建议:
            [推荐]利用延迟关联或者子查询优化超多分页场景。说明: MySQL 并不是跳过 offset 行，而是取 offset+N 行，然进行offset 行，返回 N行，那当offset 特别大的时候，
            效率就非常的低下，要么控制返回的总页数，要么对超过 特定阔值修改sql，
            正例: 先快速定位需要获取的id 段，然后再关联: SELECT a.* FROM 表1 a,(select id from 表1 where 条件 LIMit 10000000,20)b where a.id=b.id
        
        }