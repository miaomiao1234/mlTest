package com.example.mlTest.designpatterns.proxy.jdk;

/**
 * @author miaoliang
 * @since 6/22/21 10:07 AM
 */
public class ML implements Person{

    private String sex = "boy";
    private String name = "ml";
    private Integer age = 28;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAge() {
        System.out.println(age);
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void getCompanion() {
        System.out.println("My name is "+ this.name + ",sex is " +this.sex+ ",wish companion:");
        System.out.println("is a girl");
        System.out.println("sexy body");
        System.out.println("character nice");
        System.out.println("beautiful");
    }
}
