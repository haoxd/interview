package com.bread.coalquality.design.strategy.factory.state;



public class RewardStateContext {

    private RewardState rewardState;

    public void setRewardState(RewardState currentState) {
        this.rewardState = currentState;
    }

    public RewardState getRewardState() {
        return rewardState;
    }

    public void echo(RewardStateContext context, Request request) {
        rewardState.doReward(context, request);
    }
}