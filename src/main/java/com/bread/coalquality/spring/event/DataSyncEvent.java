package com.bread.coalquality.spring.event;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @Description: 数据同步事件
 * @Author: haoxd
 * @Version: 1.0
 */
@Data
@ToString
public class DataSyncEvent extends ApplicationEvent {

    private Integer eventId;

    public DataSyncEvent(Object source) {
        super(source);
    }
}
