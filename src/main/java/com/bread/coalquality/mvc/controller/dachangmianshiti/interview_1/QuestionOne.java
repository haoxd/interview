package com.bread.coalquality.mvc.controller.dachangmianshiti.interview_1;

/**
 * @Description: java 当中是否支持多继承？
 * @Author: haoxd
 * @Version: 1.0
 */
public class QuestionOne {


    class A {


    }


    abstract class B extends A {

        public void doSomethIng() {
            // do nothing
        }

    }

    class C extends B implements D, E {
        // java8 之后可以利用default 方法进行多基础

    }


    public interface D {

        default void execute() {

        }

    }

    public interface E {
        default void action() {

            System.out.println("Action .......");
        }
    }
}
