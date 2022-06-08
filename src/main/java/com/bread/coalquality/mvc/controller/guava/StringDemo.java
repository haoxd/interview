package com.bread.coalquality.mvc.controller.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class StringDemo {


    private static final Joiner joiner = Joiner.on(",").skipNulls();


    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();


    public static void main(String[] args) {


        List<String> list = Arrays.asList("1", "2", null, "4");

        System.out.println(joiner.join(list));

        String join = Joiner.on(".").join("123", "123");
        System.out.println("11111111111111111111111111:"+join);


        List<String> list1 = splitter.splitToList(",a,,,b,c,,");
        System.out.println(list1);


        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        System.out.println(nullOrEmpty);

        String join1 = Ints.join(",", 1, 1, 2);
        System.out.println(join1);

    }
}
