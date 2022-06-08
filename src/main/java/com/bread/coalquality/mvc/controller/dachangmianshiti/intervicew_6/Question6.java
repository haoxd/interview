package com.bread.coalquality.mvc.controller.dachangmianshiti.intervicew_6;

import java.lang.reflect.Field;

/**
 * @Description: <p>
 * <p>
 * <p>
 * </>
 * @Author: haoxd
 * @Version: 1.0
 */
public class Question6 {

    /**
     * String 是否是线程安全的
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        String s = "abc";

        Field field = String.class.getDeclaredField("value");


        field.setAccessible(true);


        char value[] = (char[]) field.get(s);
        value[0] = '1';
        value[1] = '2';
        value[2] = '3';

        System.out.println(s);

    }


}
