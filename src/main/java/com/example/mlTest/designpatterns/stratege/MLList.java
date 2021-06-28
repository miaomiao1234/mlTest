package com.example.mlTest.designpatterns.stratege;

import java.util.Comparator;
import java.util.List;

/**
 * @author miaoliang
 * @since 6/25/21 10:49 AM
 */
public class MLList {

    public static int sort(List list,MLComparator comparator){
        int sort = comparator.sort(list);
        System.out.println("根据传入不同的对象执行逻辑不通");
        return sort;
    }

}
