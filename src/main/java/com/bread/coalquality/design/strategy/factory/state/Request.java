package com.bread.coalquality.design.strategy.factory.state;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class Request {
    private long userId;
    private long orderId;
}
