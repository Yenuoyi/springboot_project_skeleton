package com.example.skeleton.common.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Author: yebing
 * @Date: 2018-8-21 10:54
 * @Version 1.0.0
 */
public class LinkAndArray {
    public static void main(String[] args){
        List<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> arrayList = new ArrayList<Integer>();
        long start;
        long end;
        for(int i=0;i<10000000;i++){
            linkedList.add(new Random().nextInt());
            arrayList.add(new Random().nextInt());
        }
        start = System.currentTimeMillis();
        linkedList.add(50,555);
        end = System.currentTimeMillis();
        System.out.println("linkedList中间插入耗时："+(end-start));
        start = System.currentTimeMillis();
        arrayList.add(50,555);
        end = System.currentTimeMillis();
        System.out.println(linkedList.size()+"   "+end+"  "+start);
        System.out.println("arrayList中间插入耗时："+(end-start));
    }
}
