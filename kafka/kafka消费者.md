

#### kafka消费者
- 消费模式
        
        {
            1 pull （拉）模式（kafka conusmer 采用主动从broker拉的模式）     
            2 push（推）模式
                   因为由broker端决定 消息的推送效率，很难适应消费者的消费效率，
        
        }

- 消费者
        
        {
                1 消费者和消费者是互不影响的
                2 每个分区的数据只能由消费者组当中的一个消费者消费
                3  一个消费者可以消费多个分区的数据
                4 每个消费者的offset由消费者提交到系统的主题保存
        }                   
        
        
- 消费者组
     消费者组，由多个consumer组成，形成一个消费者组的  条件是 所有的消费者的groupId是相同的
        
        {
                1  消费者组内的每一个消费者负责消费不同分区的数据，一个分区只有由一个消费者组内的一个消费者进行消费
                2  消费者组直接互不影响，所有的消费者都属于某一个消费者组。也就是一个消费者组是一个逻辑上的一个订阅者
                3  如果消费者组内添加了更多了消费者，超过了主题分区的数量，则有一部分的消费者就会处于空闲，不会接受任何的消息
                
        }
        
        
- 消费者组的初始化
        
         coordinator：辅助实现消费者组的初始化和分区的分配
         coordinator的选址：groupId 的hashCode % 50 (__consumer_offsets的分区数量) ，这个值在那个broker上就选址这个节点的
         coordinator作为消费者组的leader。消费者组下的所有消费者提交的offset就会提交在这个分区下  
        
            {
              1  每一个consumer 都会发送加入组的请求
              2  coordinator 会随机选址一个consumber作为leader
              3  把要消费的topic情况，发送给leader消费者
              4  laeader 指制定消费计划
              5  消费者leader把消费计划 发送给 coordinator
              6  coordinator把消费方案同步给各个消费者
              7  每个消费者会和coordinator进行心跳同步（默认3秒），一旦超时（session.time.out=45s）,
                    该消费者就会被移除。储发消费动态重平衡，或者消费者处理消息时间 过长（max.poll.interval.ms 5分钟）
                    也会触发在平衡
            }
            
- 消费者组消费流程
        
        {
            1 消费者发送消费请求到consumerNetWorkClient 
            2 consumerNetWorkClient  发送send请求到broker端
            3 broker端调用回调onSuccess方法
            4 进行数据的反序列化
            5 经过拦截器
            6 处理数据 
        }
    
        
        {
            重要参数
            fetch.min.bytes(每批次最小抓取大小)默认是1字节
            fetch.max.wait.ms(一批数据拉取的最大等待时间)默认是500s
            fetch.max.bytes(每批次最大拉取的数据大小)默认50M
            max.poll.recoreds(每批次最大的拉取的数据条数)默认500条
        }