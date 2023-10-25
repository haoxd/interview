package com.bread.coalquality.design.strategy.factory.state.impl;

import com.bread.coalquality.design.strategy.factory.state.Request;
import com.bread.coalquality.design.strategy.factory.state.RewardState;
import com.bread.coalquality.design.strategy.factory.state.RewardStateContext;


// 待校验状态
public class OrderCheckState extends RewardState {

    @Override
    public void doReward(RewardStateContext context, Request request) {
            // // 对进来的订单进行校验，判断是否用券，
            //是否满足优惠条件等等
    }
}