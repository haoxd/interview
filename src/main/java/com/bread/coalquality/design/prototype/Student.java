package com.bread.coalquality.design.prototype;

public class Student implements Cloneable {

    private String name; // 学生姓名
    private Teacher teacher; // 定义老师类

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
            Teacher teacher = this.teacher.clone();// 克隆 teacher 对象
            student.setTeacher(teacher);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }

} 
