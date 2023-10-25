package com.bread.coalquality.sys.threadpool;

import java.util.concurrent.ThreadFactory;

/**
 * 自定义线程工厂的名称
 **/
public class ThreadPoolThreadFactory implements ThreadFactory {

    private String name;

    ThreadPoolThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("com.asiainfo.nmcuc.pso.fc.core.threadpool-" + name + t.getId());
        return t;
    }
}