package com.bread.coalquality.design.flyweight;

// 具体享元类
public class ConcreteFlyweight implements Flyweight {

    private String type;

    public ConcreteFlyweight(String type) {
        this.type = type;
    }

    @Override
    public void operation(String name) {
        System.out.printf("[类型 (内在状态)] - [名字 (外在状态)] :"+ type);
    }

    @Override
    public String getType() {
        return type;
    }

}