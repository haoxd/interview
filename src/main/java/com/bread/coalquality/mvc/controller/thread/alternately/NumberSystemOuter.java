package com.bread.coalquality.mvc.controller.thread.alternately;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 数字输出者
 * @Author: haoxd
 * @Version: 1.0
 */
public class NumberSystemOuter implements Runnable{


    private static final Set<Integer> number = new HashSet<>();
    static {
        number.add(1);
        number.add(2);
        number.add(3);
    }


    private final ReentrantLock lock;
    private final Condition AlphabetSystemOuter;
    private final Condition NumberSystemOuter;


    public NumberSystemOuter(ReentrantLock lock, Condition AlphabetSystemOuter, Condition NumberSystemOuter) {
        this.lock = lock;
        this.AlphabetSystemOuter = AlphabetSystemOuter;
        this.NumberSystemOuter = NumberSystemOuter;
    }

    @Override
    public void run() {


        number.forEach(s -> {

            lock.lock();

            try {
                NumberSystemOuter.await();

                System.out.println(s);
                TimeUnit.SECONDS.sleep(2);

                AlphabetSystemOuter.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });


    }


}
