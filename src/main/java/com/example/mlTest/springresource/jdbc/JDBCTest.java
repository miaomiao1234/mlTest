package com.example.mlTest.springresource.jdbc;

import com.alibaba.fastjson.JSON;
import com.example.mlTest.springresource.aop.model.Member;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoliang
 * @since 7/26/21 11:24 AM
 */
public class JDBCTest {
    public static void main(String[] args) {
        // 原生的JDBC 如何操作
        try {
            // 被封装成了DataSource，放入到连接池
            // 目的是为了提高程序响应速度
            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            // 建立连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest","root","miao1234");
            // 创建语句集
            PreparedStatement ps = connection.prepareStatement("select * from persons");
            // 执行
            ResultSet rs = ps.executeQuery();
            // 封装了一个ORM的过程
            // Object Relation Mapping 对象关系映射 自动变成一个我们自己写的Java对象实体类
            int len = rs.getMetaData().getColumnCount();
            // 获取结果集
            List result = new ArrayList<Member>();
            while (rs.next()) {
                Class<Member> clazz = Member.class;
                Member member = clazz.getDeclaredConstructor().newInstance();
                for (int i = 1; i <= len; i++) {
                    ResultSetMetaData metaData = rs.getMetaData();
                    String columnName = rs.getMetaData().getColumnName(i);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    Object type = field.getType();
                    if (type == int.class) {
                        field.set(member,rs.getInt(columnName));
                    } else if (type == String.class) {
                        field.set(member,rs.getString(columnName));
                    }
                }
                result.add(member);
//                System.out.println(rs.getLong("id"));
//                System.out.println(rs.getString("name"));
//                System.out.println(JSON.toJSON(member));
            }
            result.stream().forEach(System.out::println);
            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
