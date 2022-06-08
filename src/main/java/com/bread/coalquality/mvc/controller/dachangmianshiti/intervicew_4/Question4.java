package com.bread.coalquality.mvc.controller.dachangmianshiti.intervicew_4;

/**
 * @Description: <p>
 * <p> finally 语句除了 jvm推退出 都会执行
 * <p>
 * </>
 * @Author: haoxd
 * @Version: 1.0
 */
public class Question4 {

    /**
     * A true
     * B false
     * C 编译错误
     * D 以上答案都不是
     */
    public static void main(String[] args) {


        boolean flag = false;

        try {
            if (flag) {

                while (true) {


                }

            } else {
                // System.exit(1);
                throw new Exception();
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println("finally");
        }


    }


}
