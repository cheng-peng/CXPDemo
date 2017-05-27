package com.cxp.lambda;

/**
 * @author CXP
 * @desc demo2使用的类
 * @time 2017/1/12 16:40
 * @email q978515743@163.com
 */

public class Teacher extends User {

    private String name;
    private Integer age;

    public Teacher(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println(name+"今年"+age+"了,是一位老师！");
    }
}

class Student extends User {
    private String name;
    private Integer age;
    public Student(String name, int age) {
        super(name, age);
        this.name=name;
        this.age=age;
    }

    @Override
    public void say() {
        System.out.println(name+"今年"+age+"了,是一位学生！");
    }
}
