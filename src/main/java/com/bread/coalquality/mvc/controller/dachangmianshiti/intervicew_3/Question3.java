package com.bread.coalquality.mvc.controller.dachangmianshiti.intervicew_3;

/**
 * @Description:
 * <p>
 * <p>
 * <p>
 * </>
 * @Author: haoxd
 * @Version: 1.0
 */
public class Question3 {

    /**
     *  A true
     *  B false
     *  C 编译错误
     *  D 以上答案都不是
     *
     *
     *
     * */
    public static void main(String[] args) {

        String a1="abc";
        String a2 = new String("abc");

        a2.intern();

        System.out.println(a1==a2);




    }



}
