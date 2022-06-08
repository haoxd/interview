package com.bread.coalquality.mvc.controller;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class HashMapConcurrentTest {



    private static final Map<String, Object> body = Maps.newHashMap();

    private final static CountDownLatch countDownLatch = new CountDownLatch(20);

    public static void main(String[] args) throws InterruptedException {


        IntStream.rangeClosed(1, 10).forEach(value -> {


            new Thread(() -> {

                body.put("" + value, value);

            }).start();
            countDownLatch.countDown();
        });

        IntStream.rangeClosed(1, 10).forEach(value -> {

            new Thread(() -> {

                body.put("" + value, value + ",");
            }).start();
            countDownLatch.countDown();
        });

        System.out.println(countDownLatch.getCount());
        countDownLatch.await();

        System.out.println(body.toString());
        System.out.println("_______________________________________________");
        System.out.println(body.get("3"));
    }
}
