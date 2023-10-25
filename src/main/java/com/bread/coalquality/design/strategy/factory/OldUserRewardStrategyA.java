package com.bread.coalquality.design.strategy.factory;

// 老用户返奖具体策略 A
public class OldUserRewardStrategyA extends RewardStrategy {
 @Override
 public int reward(long userId) {
     return 1;

 } // 具体的计算逻辑，...
}