package com.bread.coalquality.design.strategy.factory;

public class RewardContext {

    private RewardStrategy strategy;

    public RewardContext(RewardStrategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(long userId) {


        int reward = strategy.reward(userId);

        strategy.insertRewardAndSettlement(userId,  reward);

    }
}