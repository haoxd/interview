package com.bread.coalquality.design.flyweight;

// 抽象享元类
public interface Flyweight {
    // 对外状态对象
    void operation(String name);

    // 对内对象
    String getType();
}
