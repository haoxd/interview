package com.bread.coalquality.design.strategy.factory.state;



public abstract class RewardState {

    public abstract void doReward(RewardStateContext context, Request request);
}