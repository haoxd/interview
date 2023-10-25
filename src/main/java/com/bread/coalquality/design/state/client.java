package com.bread.coalquality.design.state;

// 定义 client 执行
public class client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        context.handle1();
        context.handle2();
    }
}