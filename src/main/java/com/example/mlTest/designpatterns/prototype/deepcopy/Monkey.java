package com.example.mlTest.designpatterns.prototype.deepcopy;


import java.util.Date;

/**
 * @author miaoliang
 * @since 6/27/21 2:35 PM
 */
public class Monkey {

    // 身高  基本数据类型
    private int height;

    private int weight;
    //封装类型
    private Date birthday;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
