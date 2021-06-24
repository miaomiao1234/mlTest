package com.example.mlTest.designpatterns.proxy.jdk;

//import sun.misc.ProxyGenerator;

/**
 * @author miaoliang
 * @since 6/22/21 10:12 AM
 *
 */
public class JDKProxyDemo {

    public static void main(String[] args) {
        ML ml = new ML();
//        System.out.println(ml);
//        System.out.println(ml.getClass());
        Person instance = (Person) new MatchMaker().getInstance(ml);
        instance.getCompanion();
//        System.out.println("==============");
//        System.out.println(instance.getName());
        // 获取生成代理类的字节码内容
//        ProxyGenerator.generateProxyClass()
    }

}
