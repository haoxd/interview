package com.bread.coalquality.mvc.controller;

import java.io.IOException;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class TestThisEscape {


    private int sum =8;


    public TestThisEscape(){

        new Thread(()->System.out.println(this.sum)).start();
    }

    public static void main(String[] args) throws IOException {



       for (int i = 0; i < 1000; i++) {
           new Thread(()->{


               for (int a = 0; a < 1000; a++) {
                   new TestThisEscape();
               }


           }).start();

       }


    }

}
