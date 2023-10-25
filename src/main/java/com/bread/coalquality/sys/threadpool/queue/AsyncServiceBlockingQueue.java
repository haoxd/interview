package com.bread.coalquality.sys.threadpool.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description: 异步服务阻塞队列
 * @Author: haoxd
 * @Version: 1.0
 */
public class AsyncServiceBlockingQueue implements CustomBlockingQueue {


    private static final Integer TYPE= 13;

    @Override
    public Integer getType() {
        return TYPE;
    }

    @Override
    public BlockingQueue generateBlockingQueue() {
       return new LinkedBlockingDeque<>(1024);

    }

    @Override
    public String getName() {
        return "ASYNC_SERVICE_QUEUE";
    }
}
