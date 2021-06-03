package com.example.mlTest.newfeature.jdk8.localdate;

import java.time.*;

/**
 * @author miaoliang
 * @since 6/3/21 11:16 AM
 *
 *
 * 原始日期 API 存在问题：
 *  1. 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 *  2. 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。
 *      java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 *  3. 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 *
 *
 *  Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 *      1. Local(本地) − 简化了日期时间的处理，没有时区的问题。
 *      2. Zoned(时区) − 通过制定的时区处理日期时间。
 *      3. 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        testLocalDateTime();
        System.out.println("====================");
        testZonedDateTime();
    }

    private static void testZonedDateTime() {
        System.out.println(ZonedDateTime.parse("2021-06-03T10:15:30+05:30[Asia/Shanghai]"));
        System.out.println(ZoneId.of("Europe/Paris"));
        System.out.println(ZoneId.systemDefault());
    }

    private static void testLocalDateTime() {
        /**
         * localDateTime
         */
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        LocalDate localDate = currentTime.toLocalDate();
        System.out.println(localDate);
        System.out.println(currentTime.getMonth());
        System.out.println(currentTime.getDayOfMonth());
        System.out.println(currentTime.getSecond());
        // 在当前基础上 指定日期
        System.out.println(currentTime.withMonth(9).withDayOfMonth(28).withYear(1992));
        System.out.println("=============================");
        /**
         * localDate
         */
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(1992, Month.SEPTEMBER, 28));
        System.out.println(LocalTime.of(20, 20));
        System.out.println(LocalTime.parse("20:15:30"));
    }

}
