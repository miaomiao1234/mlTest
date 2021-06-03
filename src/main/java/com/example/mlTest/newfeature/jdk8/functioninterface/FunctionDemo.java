package com.example.mlTest.newfeature.jdk8.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author miaoliang
 * @since 6/1/21 11:02 AM
 *
 *
 * 函数式接口：就是有且仅有一个抽象方法，但是可以有多个方法的接口
 *  1. 函数式接口可以隐式转换为 lambda 表达式
 *
 */
public class FunctionDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据");
        eval(list,n -> true);
        System.out.println("输出2的倍数的数");
        eval(list,n -> n%2 == 0);
        System.out.println("输出大于3的数");
        eval(list,n -> n > 3);
        Predicate<Integer> predicatre = n -> n < 4;
        list.forEach(predicatre::test);
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
