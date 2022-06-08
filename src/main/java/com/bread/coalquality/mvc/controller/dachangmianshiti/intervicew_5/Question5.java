package com.bread.coalquality.mvc.controller.dachangmianshiti.intervicew_5;

import java.lang.reflect.Field;

/**
 * @Description: <p>
 * <p>
 * <p>
 * </>
 * @Author: haoxd
 * @Version: 1.0
 */
public class Question5 {

    /**
     * A throw
     * B 没有输出结果
     * C 编译出错
     * D 以上答案都不是
     *
     * 答案：C
     */
    public static void main(String[] args) {

        try {

            throwNPE();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void throwNPE() {

        throw new NullPointerException("throw");

    }



}
