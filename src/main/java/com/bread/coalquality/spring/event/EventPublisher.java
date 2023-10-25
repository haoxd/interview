package com.bread.coalquality.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 事件发布者
 * @Author: haoxd
 * @Version: 1.0
 */
public interface EventPublisher<T extends ApplicationEvent> {

    String DATA_SYNC_PUBLISHER="dataSyncPublisher";


    /**
     * 发布
     * @param t 发布的事件
     * */
    void publish(T t);

}
