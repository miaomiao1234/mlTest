package com.example.mlTest.designpatterns.stratege;

import java.util.List;

/**
 * @author miaoliang
 * @since 6/25/21 10:56 AM
 */
public class NumberComparator implements MLComparator {
    @Override
    public int sort(List list) {
        System.out.println("数字比较排序的算法");
        return 0;
    }
}
