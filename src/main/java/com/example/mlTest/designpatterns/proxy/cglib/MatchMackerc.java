package com.example.mlTest.designpatterns.proxy.cglib;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author miaoliang
 * @since 6/24/21 9:40 AM
 *
 * 同样做了一件字节码重组的事情，对于使用API的用户来说是没有感知的
 */
public class MatchMackerc implements MethodInterceptor {

    public Object getInstance(Class clazz){
        // 通过反射机制给他实现
        Enhancer enhancer = new Enhancer();
        // 把父类设置为谁，告诉cglib父类是谁
        enhancer.setSuperclass(clazz);
        enhancer.setCallback((Callback) this);
        // 第一步生成源代码
        // 第二步编译成class 文件
        // 第三步加载到JVM并返回代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("获取主人性别信息中...");
        System.out.println("主人");
        System.out.println("期望：");
        // 这个 Object 的引用是 cglib 给我们 new 出来的
        // cglib new出来的对象是传入类的子类（继承自传入的类）
        // OOP，在new子类之前，实际上默认先调用了父类的super（）方法，加载子类的同时，先加载父类，相当于间接的引用了父类，
        // 子类重写了父类的所有方法，改变子类对象的属性，相当于间接更改了父类
        methodProxy.invokeSuper(o,objects);
        System.out.println(method.getName());
//        methodProxy.invoke(o,objects); //死循环
        System.out.println("获取信息处理中~~~~~~");
        return null;
    }
}
