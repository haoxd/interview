package com.bread.coalquality.sys.threadpool.queue;

import java.util.concurrent.BlockingQueue;

public interface CustomBlockingQueue {

    Integer getType();

    default String getName() {
        return "";
    }

    BlockingQueue generateBlockingQueue();
}
