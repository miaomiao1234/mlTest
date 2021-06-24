package com.example.mlTest.designpatterns.proxy.jdk;

/**
 * @author miaoliang
 * @since 6/22/21 10:04 AM
 */
public interface Person {

    // 相亲接口
    void getCompanion();

    // 获取被代理者信息
    String getName();
    String getSex();
    Integer getAge();

}
