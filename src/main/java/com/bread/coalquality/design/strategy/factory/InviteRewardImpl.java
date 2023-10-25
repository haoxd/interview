package com.bread.coalquality.design.strategy.factory;

public class InviteRewardImpl {
    // 返奖主流程
    public void sendReward(long userId) {
        FactorRewardStrategyFactory strategyFactory = new FactorRewardStrategyFactory(); // 创建工厂

        boolean userType = getUserType(userId);

        if(userType){

            NewUserRewardStrategyA strategy = (NewUserRewardStrategyA)strategyFactory.createStrategy(NewUserRewardStrategyA.class);
            RewardContext rewardContext = new
                    RewardContext(strategy);

            rewardContext.doStrategy(userId);
        }else{


        }



    }


    private boolean getUserType(long userId){
        return false;
    }

}