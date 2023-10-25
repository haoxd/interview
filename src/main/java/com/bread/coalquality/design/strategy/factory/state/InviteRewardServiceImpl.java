package com.bread.coalquality.design.strategy.factory.state;

import com.bread.coalquality.design.strategy.factory.state.impl.CompensateRewardState;
import com.bread.coalquality.design.strategy.factory.state.impl.OrderCheckState;


/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class InviteRewardServiceImpl {

    public boolean sendRewardForInvtee(long userId, long orderId) {



        Request request = new Request(userId, orderId);
        RewardStateContext rewardContext = new RewardStateContext();
        rewardContext.setRewardState(new OrderCheckState());
        rewardContext.echo(rewardContext, request); // 开始返奖，订单校验


        return true;
    }
}
