package com.bread.coalquality.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据同步启动者
 */
@Component
@Slf4j
public class DataSyncCommandLineRunner implements CommandLineRunner {


    @Autowired
    @Qualifier(EventPublisher.DATA_SYNC_PUBLISHER)
    private EventPublisher eventPublisher;

    @Override
    public void run(String... args) {

        Map<String, Object> data = new HashMap<>(16);
        data.put("orderId", "12348484");
        DataSyncEvent dataSyncEvent = new DataSyncEvent(data);
        dataSyncEvent.setEventId(1);
        eventPublisher.publish(dataSyncEvent);

    }


}