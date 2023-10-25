package com.bread.coalquality.mvc.controller.thread.alternately;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 字母输出者
 * @Author: haoxd
 * @Version: 1.0
 */
public class AlphabetSystemOuter implements Runnable {


    private static final Set<String> alphabet = new HashSet<>();

    static {
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");


    }

    private final ReentrantLock lock;
    private final Condition AlphabetSystemOuter;
    private final Condition NumberSystemOuter;


    public AlphabetSystemOuter(ReentrantLock lock, Condition AlphabetSystemOuter, Condition NumberSystemOuter) {
        this.lock = lock;
        this.AlphabetSystemOuter = AlphabetSystemOuter;
        this.NumberSystemOuter = NumberSystemOuter;
    }

    @Override
    public void run() {


        alphabet.forEach(s -> {

            lock.lock();

            try {
                System.out.println(s);
                TimeUnit.SECONDS.sleep(2);
                NumberSystemOuter.signal();
                AlphabetSystemOuter.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });


    }
}
