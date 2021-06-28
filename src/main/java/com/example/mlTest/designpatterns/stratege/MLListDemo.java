package com.example.mlTest.designpatterns.stratege;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author miaoliang
 * @since 6/25/21 10:42 AM
 *
 * 策略模式：
 * 返回的值是固定的，中间的执行逻辑不一样
 */
public class MLListDemo {
    public static void main(String[] args) {
        List list = new ArrayList<Long>();
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long aLong, Long t1) {

                return 0;
            }
        });
        int sort = MLList.sort(list, new NumberComparator());
        int sort1 = MLList.sort(list, new ObjectComparator());
    }
}
