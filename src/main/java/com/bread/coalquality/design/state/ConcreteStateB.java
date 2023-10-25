package com.bread.coalquality.design.state;

// 定义状态 B
public class ConcreteStateB extends State {
    // 本状态下必须要处理的事情，...
    @Override
    public void handle2() {
        System.out.println("ConcreteStateB");
    }

    @Override
    public void handle1() {
        super.context.setCurrentState(Context.contreteStateA); // 切换到状态 A

        super.context.handle1(); // 执行状态 A 的任务
    }
}