package com.bread.coalquality.mvc.controller.dachangmianshiti.intervicew_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: jvm 当中是如何实现java7 当中 try-with-resources 特性的？
 * <p>
 * <p> 1 必须针对 实现了AutoCloseable的接口的对象 (java 编译器做的字节码提升)
 * <p>
 * </>
 * @Author: haoxd
 * @Version: 1.0
 */
public class Question2 {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(new File("/temp"));
        } catch (Exception e) {

        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void tryWithResources() {


        try (FileInputStream fileInputStream = new FileInputStream(new File("/temp"))) {


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
