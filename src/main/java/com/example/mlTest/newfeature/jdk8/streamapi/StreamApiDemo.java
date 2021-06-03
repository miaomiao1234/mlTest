package com.example.mlTest.newfeature.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author miaoliang
 * @since 6/2/21 4:02 PM
 *
 *  定义：
 *      Stream java 8中新的抽象，可以用声明的方式处理数据
 *      Stream （流）是一个来自数据源的元素队列，并支持聚合操作
 *
 *      数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
 *      聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
 *      和以前的Collection操作不同， Stream操作还有两个基础的特征：
 *
 *      Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
 *      内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。
 */
public class StreamApiDemo {
    public static void main(String[] args) {
        /**
         *  1. stream 为集合创建串行流
         *  2. parallelstream 为集合创建并行流
         */
        // 生成流
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        // parallelStream 是流并行处理程序的代替方法
        List<String> parallelFiltered = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        filtered.forEach(System.out::println);
        System.out.println("======================================");
        parallelFiltered.forEach(System.out::println);
        System.out.println("======================================");
        // forEach stream 中用来迭代每个数据的方法
        // limit 方法用于获取指定数量的流
        Random random = new Random();
        // sorted 方法用于对流进行排序
        random.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("======================================");
        // map 用于映射每个元素对应的结果的方法
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 映射为 平方
        List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("======================================");
        // filter 方法用于通过设置的条件过滤出元素
        System.out.println(strings.stream().filter(string -> !string.isEmpty()).count());
        System.out.println("======================================");
        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
        String merged = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串："+merged);
    }
}
