package com.example.mlTest.designpatterns.proxy.jdk.custom;

import com.example.mlTest.designpatterns.proxy.jdk.ML;
import com.example.mlTest.designpatterns.proxy.jdk.MatchMaker;
import com.example.mlTest.designpatterns.proxy.jdk.Person;

/**
 * @author miaoliang
 * @since 6/22/21 10:12 AM
 */
public class MLJDKProxyDemo {

    public static void main(String[] args) {
        ML ml = new ML();
        Person instance = (Person) new MLMatchMaker().getInstance(ml);
//        instance.getCompanion();
//        System.out.println("==============");
//        System.out.println(instance.getName());
        // 获取生成代理类的字节码内容
//        ProxyGenerator.generateProxyClass()
    }

}
