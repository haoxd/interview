package com.bread.coalquality.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: 事件发布者
 * @Author: haoxd
 * @Version: 1.0
 */
@Component(EventPublisher.DATA_SYNC_PUBLISHER)
@Slf4j
public class DataSyncPublisher implements EventPublisher<DataSyncEvent>,ApplicationContextAware {

    private  ApplicationContext applicationContext;


    /**
     * 发布
     *
     * @param testEvent 发布的事件
     */
    @Override
    public void publish(DataSyncEvent testEvent) {
        log.info("开始发布事件");
        applicationContext.publishEvent(testEvent);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
