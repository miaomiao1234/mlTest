package com.example.mlTest.newfeature.jdk8.opetional;

import java.util.Optional;

/**
 * @author miaoliang
 * @since 6/2/21 9:26 PM
 *
 * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 *
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 *
 * Optional 类的引入很好的解决空指针异常。
 */
public class OpetionalDemo {

    public static void main(String[] args) {
        OpetionalDemo demo = new OpetionalDemo();
        Integer v1 = null;
        Integer v2 = new Integer(10);
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(v1);
        System.out.println(a);
        System.out.println(Optional.of(a));
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(v2);
        System.out.println(b);
        System.out.println(Optional.ofNullable(b));

        // Optional.isPresent - 判断值是否存在
        System.out.println("a 是否存在："+a.isPresent());
        System.out.println("b 是否存在："+b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        v1 = a.orElse(new Integer(0));
        System.out.println(v1);

        //Optional.get - 获取值，值需要存在
        System.out.println(b.get());
        System.out.println(v1+v2);

    }

}
