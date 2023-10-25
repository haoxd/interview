package com.bread.coalquality.mvc.controller.philosopher.dining;

/**
 * @Description: 哲学家就餐问题，面向对象编程
 * @Author: haoxd
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        Chopsticks chopsticks1 = new Chopsticks();
        Chopsticks chopsticks2 = new Chopsticks();
        Chopsticks chopsticks3 = new Chopsticks();
        Chopsticks chopsticks4 = new Chopsticks();
        Chopsticks chopsticks5 = new Chopsticks();


        Philosopher philosopher1 = new Philosopher("亚里士多德",1,chopsticks1,chopsticks2);
        Philosopher philosopher2 = new Philosopher("莎士比亚",2,chopsticks2,chopsticks3);
        Philosopher philosopher3 = new Philosopher("牛顿",3,chopsticks3,chopsticks4);
        Philosopher philosopher4 = new Philosopher("爱因斯坦",4,chopsticks4,chopsticks5);
        Philosopher philosopher5 = new Philosopher("爱迪生",5,chopsticks5,chopsticks1);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();


    }
}
