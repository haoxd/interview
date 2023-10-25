package com.bread.coalquality.design.state;

public class ConcreteStateA extends State {
    //// 本状态下必须要处理的事情
    @Override
    public void handle1() {
        System.out.println("ConcreteStateA");
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(Context.contreteStateB); // 切换到状态 B

        super.context.handle2(); // 执行状态 B 的任务

    }
}