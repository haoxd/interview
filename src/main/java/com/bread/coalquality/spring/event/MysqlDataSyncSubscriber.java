package com.bread.coalquality.spring.event;

import com.bread.coalquality.sys.threadpool.ThreadPoolProviderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description: mysql数据同步事件订阅者
 * @Author: haoxd
 * @Version: 1.0
 */
@Slf4j
@Component
public class MysqlDataSyncSubscriber implements ApplicationListener<DataSyncEvent>{


    @Override
    @Async(ThreadPoolProviderUtil.ASYNC_SERVICE_EXECUTOR)
    public void onApplicationEvent(DataSyncEvent testEvent) {
        log.info("mysql数据同步事件订阅者监听到事件");
        log.info(testEvent.getSource().toString());
    }
}
