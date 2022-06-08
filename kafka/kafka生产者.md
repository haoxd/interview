

#### kafka生产者
- 吞吐量四个重要参数配置
        
        {
            1 缓冲区大小 RecordAccumulator 缓冲区总大小，默认 32m。
            2 批次大小 缓冲区一批数据最大值，默认 16k。适当增加该值，可以提高吞吐量，但是如果该值设置太大，会导致数据传输延迟增加。
            3 linger.ms 如果数据迟迟未达到 batch.size，sender 等待 linger.time之后就会发送数据。单位 ms，默认值是 0ms，表示没有延迟。生产环境建议该值大小为 5-100ms 之间。
            4 压缩类型 生产者发送的所有数据的压缩方式。默认是 none，也就是不压缩。支持压缩类型：none、gzip、snappy、lz4 和 zstd。
        }
- 数据生产环境可靠性acks  
    
        {
         0：生产者发送过来的数据，不需要等数据落盘应答。  
         1：生产者发送过来的数据，Leader收到数据后应答
         -1：生产者发送过来的数据，Leader和ISR队列里面的所有节点收齐数据后应答。

        }
      数据完全可靠的必要条件
                 
                {
                数据完全可靠条件 = ACK级别设置为-1 + 分区副本大于等于2 + ISR里应答的最小副本数量大于等于2
                    ISR（）
                
                }
                
- 数据生产环境数据重复性
        
        {
            数据传递语义：
                1 至少一次（ at last once）=ACK级别设置为-1 + 分区副本大于等于2 + ISR里应答的最小副本数量大于等于2
                2 最多一次（at most once） = acks级别设置为 0
                 总结：
                  至少一次（ at last once） 可以保证 数据不丢失，但是不能保证数据不重复
                  最多一次（at most once）  可以保证数据不重复，但是不能保证数据不丢失
                3 精确一次 （exactly once）保证不重复，也保证不丢失 == 幂等性 + 至少一次（ ack=-1 + 分区副本数>=2 + ISR最小副本数量>=2） 。

                    幂等性就是指Producer不论向Broker发送多少次重复数据，Broker端都只会持久化一条，保证了不重复。
                    重复数据的判断标准：具有<PID, Partition, SeqNumber>相同主键的消息提交时，Broker只会持久化一条。其
                    中PID是Kafka每次重启都会分配一个新的；Partition 表示分区号；Sequence Number是单调自增的。
                    所以幂等性只能保证的是在单分区单会话内不重复。
                    
                    如何使用幂等性
                    开启参数 enable.idempotence 默认为 true，false 关闭。
                    
                4 生产经验——数据乱序
                    2）kafka在1.x及以后版本保证数据单分区有序，条件如下：
                    （2）开启幂等性
                    max.in.flight.requests.per.connection需要设置小于等于5。
                    （1）未开启幂等性
                    max.in.flight.requests.per.connection需要设置为1。
                    原因说明：因为在kafka1.x以后，启用幂等后，kafka服务端会缓存producer发来的最近5个request的元数据，
                    故无论如何，都可以保证最近5个request的数据都是有序的。


        }

  
- zookeeper 存储的kafka信息


                {
                    1 /kafka/brokers/ids [0,1,2] 记录有哪些服务器
                    2 /kafka/brokers/topics/first/partitions/0/state {"leader":1 ,"isr":[1,0,2] } 记录谁是Leader，有哪些服务器可用
                    3 /kafka/controller 
                }
                
- 生产经验——节点服役和退役
            
                {
                
                }
                
- 副本

        {
            1 AR Kafka 分区中的所有副本统称为 AR（Assigned Repllicas）。AR = ISR + OSR
            2 ISR，表示和 Leader 保持同步的 Follower 集合。
                    如果 Follower 长时间未向 Leader 发送通信请求或同步数据，则该 Follower 将被踢出 ISR。
                    该时间阈值由 replica.lag.time.max.ms参数设定，默认 30s。Leader 发生故障之后，就会从 ISR 中选举新的 Leader。
            3 OSR，表示 Follower 与 Leader 副本同步时，延迟过多的副本
        }

              