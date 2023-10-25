package com.bread.coalquality.design.strategy.factory.state.impl;

import com.bread.coalquality.design.strategy.factory.state.Request;
import com.bread.coalquality.design.strategy.factory.state.RewardState;
import com.bread.coalquality.design.strategy.factory.state.RewardStateContext;


// 待补偿状态
public class CompensateRewardState extends RewardState {
    @Override
    public void doReward(RewardStateContext context, Request request) {
         // 返奖失败，需要对用户进行返奖补偿

    }
}