package com.bread.coalquality.mvc.controller.dachangmianshiti;

import java.util.HashMap;

/**
 * @Description: 58 同城字符串常量池
 * @Author: haoxd
 * @Version: 1.0
 */
public class StringPool {


    /**
     *
     *
     *
     * **/
    public static void main(String[] args) {

/*
        String a = new StringBuilder("123").append("456").toString();
        System.out.println(a == a.intern());
        System.out.println(a.equals(a.intern()));

        String c = new StringBuilder("ja").append("va").toString();
        System.out.println(c == c.intern());
        System.out.println(c.equals(c.intern()));*/

        int[] sums = {1, 2, 3, 4, 6};
        int count = 6;


        int[] aa =twoSum2(sums, count);


        for (int i = 0; i < aa.length; i++) {

            System.out.println(aa[i]);
        }


       System.out.println( twoSum11(sums,count));
        System.out.println( twoSum111(sums,count));


    }
    /**
     *
     * 需求 给定一个数租和一个目标的结果值，返回 在数租当中 和为目标值的下角标
     *

     int[] sums = {1, 2, 3, 4, 6};
     int count = 3;
     *
     * */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            // 判断在hashmap当中是否存在数租当中的数据
            if (hash.containsKey(nums[i])) {
                // 如果存在，那么
                indexs[0] = hash.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            //不存在，hashmap 放入 目标值-减去当前数租值的 结果，和下角标index
            hash.put(target - nums[i], i);
        }

        return indexs;
    }

    public static int twoSum11(int[] nums, int target) {

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            hash.put(nums[i], i);
        }

        return hash.get(target);
    }


    public static int twoSum111(int[] nums, int target) {


        for (int i = 0; i <=nums.length; i++) {

            if(target==nums[i]){
                return i;
            }
        }

        return -1;
    }

    public static int[] twoSum2(int[] nums, int target) {


        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {


              /*  System.out.println("############################");
                System.out.println(nums[i]);
                System.out.println(nums[j]);
                System.out.println(target - nums[i]);
                System.out.println("############################");*/
                if ( nums[i] + nums[j]==target ) {
                    return new int[]{i, j};
                }

            }

        }

        return null;
    }
}
