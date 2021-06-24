package com.example.mlTest.designpatterns.proxy.cglib;

/**
 * @author miaoliang
 * @since 6/24/21 9:38 AM
 */
public class MLc {

    private String name;
    private String sex;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void getCompanion(){
        System.out.println("soulMate");
    }
}
