package com.bread.coalquality.design.flyweight;

public class Client {
    public static void main(String[] args) {
        Flyweight fw0 = FlyweightFactory.getFlyweight("a");
        Flyweight fw1 = FlyweightFactory.getFlyweight("b");
        Flyweight fw2 = FlyweightFactory.getFlyweight("a");
        Flyweight fw3 = FlyweightFactory.getFlyweight("b");
        fw1.operation("abc");
        System.out.printf("[结果 (对象对比)] - [%s]\n", fw0 == fw2);
        System.out.printf("[结果 (内在状态)] - [%s]\n", fw1.getType());
    }
}
