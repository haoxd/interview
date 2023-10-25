package com.bread.coalquality.design.strategy.factory;

// 抽象工厂
public abstract class StrategyFactory<T> {
 abstract RewardStrategy createStrategy(Class<T> c);
}