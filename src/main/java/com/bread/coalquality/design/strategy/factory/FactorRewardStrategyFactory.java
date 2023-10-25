package com.bread.coalquality.design.strategy.factory;

// 具体工厂创建具体的策略
public class FactorRewardStrategyFactory extends StrategyFactory {
    @Override
    RewardStrategy createStrategy(Class c) {
        RewardStrategy product = null;
        try {
            product = (RewardStrategy) Class.forName(c.getName()).
                    newInstance();
        } catch (Exception e) {
        }
        return product;
    }
}