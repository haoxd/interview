package com.bread.coalquality.design.strategy.factory;

// 新用户返奖具体策略 A
public class NewUserRewardStrategyA extends RewardStrategy {
 @Override
 public int reward(long userId) {

  return 0;

 } // 具体的计算逻辑，...
}