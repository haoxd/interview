package com.bread.coalquality.mvc.controller.thread.alternately;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class Exectuer {


    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        Condition AlphabetSystemOuter = lock.newCondition();
        Condition NumberSystemOuter = lock.newCondition();

        AlphabetSystemOuter alphabetSystemOuter =new AlphabetSystemOuter( lock, AlphabetSystemOuter, NumberSystemOuter);
        NumberSystemOuter numberSystemOuter =new NumberSystemOuter(lock, AlphabetSystemOuter, NumberSystemOuter);

        new Thread(()->alphabetSystemOuter.run()).start();
        new Thread(()->numberSystemOuter.run()).start();

    }


}
