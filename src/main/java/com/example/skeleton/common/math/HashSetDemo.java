package com.example.skeleton.common.math;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: yebing
 * @Date: 2018-8-21 8:50
 * @Version 1.0.0
 */
public class HashSetDemo {

    public static void main(String[] args){
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        treeSet.add(11);
        treeSet.add(22);
        System.out.println(treeSet);
        double pi=3.1415927;//圆周率
        //取一位整数
        System.out.println(new DecimalFormat("0").format(pi));//3
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%
    }
}
