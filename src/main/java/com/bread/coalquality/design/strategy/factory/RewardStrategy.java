package com.bread.coalquality.design.strategy.factory;




public abstract class RewardStrategy {

 public abstract int reward(long userId);

 public void insertRewardAndSettlement(long userId, int reward) {}

}