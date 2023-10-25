package com.bread.coalquality.design.prototype;

// 定义老师类
public class Teacher implements Cloneable {
    private String name; // 老师姓名

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    // 重写克隆方法，堆老师类进行克隆
    public Teacher clone() {
        Teacher teacher = null;
        try {
            teacher = (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }

}