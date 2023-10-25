package com.bread.coalquality.mvc.controller.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class oom {

    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        oom();
    }


    public static String oom() {
        for (int i = 0; i < 100000; i++) {
            map.put("key" + i, "value" + i);
        }
        return "oom";
    }

}
