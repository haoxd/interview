package com.bread.coalquality.sys.threadpool.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * escription: 自定义阻塞队列
 * @Author: haoxd
 * @Version: 1.0
 */
public class CsutomServiceBlockingQueue implements CustomBlockingQueue {

    private static final Integer TYPE= 14;

    @Override
    public Integer getType() {
        return TYPE;
    }

    @Override
    public String getName() {
        return "CUSTOM_SERVICE_QUEUE";
    }

    @Override
    public BlockingQueue generateBlockingQueue() {
        return new LinkedBlockingDeque<>(1024);
    }
}
