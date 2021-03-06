package com.example.mlTest.designpatterns.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author miaoliang
 * @since 6/22/21 10:16 AM
 */
// 媒婆类
public class MatchMaker implements InvocationHandler {

    // 要代理的对象设置为成员变量
    private Person target;

    // 获取被代理人的资料
    public Object getInstance(Person target){
        // 将 二进制文件输出到本机 ProxyGenerator类已不再是public，不能直接使用
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        this.target = target;
        System.out.println("获取主人模板");
        System.out.println("======================");
        System.out.println(target);
        System.out.println(target.getClass());
        System.out.println("======================");

        //1. 拿到最原始对象的引用，获取他的接口
        //2. JDK重新生成一个代理类，同时实现我们给代理对象所实现的接口
        //3. 获取到被引用的代理类对象
        //4. 重新生成一个class 字节码
        //5. 编译字节码
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        System.out.println("复制主人模板:"+instance.getClass());
        return instance;

    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("获取主人性别信息中...");
        System.out.println("主人");
        System.out.println("姓名："+target.getName());
        System.out.println("性别："+target.getSex());
        System.out.println("年龄："+target.getAge());
        System.out.println("期望：");
        method.invoke(target,objects);
//        this.target.getCompanion();
        System.out.println("获取信息处理中~~~~~~");
        return null;
    }
}
