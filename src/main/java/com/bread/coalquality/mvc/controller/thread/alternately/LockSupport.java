package com.bread.coalquality.mvc.controller.thread.alternately;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class LockSupport {



    static Thread t2;
    static Thread t1;

    public static void main(String[] args) {

        t1 = new Thread(() -> {


            for (int i = 0; i < 10; i++) {

                System.out.println("1");
                java.util.concurrent.locks.LockSupport.unpark(t2);
                java.util.concurrent.locks.LockSupport.park(t1);

            }


        },"T1");


        t2 = new Thread(() -> {


            for (int i = 0; i < 10; i++) {
                java.util.concurrent.locks.LockSupport.park(t2);
                System.out.println("0");
                java.util.concurrent.locks.LockSupport.unpark(t1);

            }


        },"T2");

        t1.start();
        t2.start();
    }


}
