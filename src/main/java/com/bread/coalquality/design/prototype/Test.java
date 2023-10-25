package com.bread.coalquality.design.prototype;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]) {
        Teacher teacher = new Teacher(); // 定义老师 1
        teacher.setName(" 刘老师 ");
        Student stu1 = new Student(); // 定义学生 1
        stu1.setName("test1");
        stu1.setTeacher(teacher);

        Student stu2 = stu1.clone(); // 定义学生 2
        stu2.setName("test2");
        stu2.getTeacher().setName(" 王老师 ");// 修改老师
        System.out.println(" 学生 " + stu1.getName() + " 的老师是:" + stu1.getTeacher().getName());
        System.out.println(" 学生 " + stu2.getName() + "的老师是:" + stu2.getTeacher().getName());


        Student stu = new Student(); // 定义学生 1

        stu.setName("11");
        stu.setTeacher(new Teacher().setName("11111111111111111"));
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student stus = stu.clone();
            stus.setName("1"+i);
            stus.setTeacher(new Teacher().setName("1"));
            students.add(stus);

        }

        System.out.println(JSONObject.toJSONString(students));




    }
}
