package com.example.skeleton.common.math;

import java.io.Serializable;

/**
 * @Author: yebing
 * @Date: 2018-8-21 11:17
 * @Version 1.0.0
 */
public class Millionaire implements Serializable {

    public static void main(String[] args){
        int year = 0;
        double f = 1000000;
        double p = 100000;
        double r = 0.05;
        for(int i=1;;i++){
            double n = Math.pow(f/p,1.0/i);
            if(n<=(1+r)){
                year = i;
                break;
            }
        }
        System.out.println(year+"年后成为百万富翁！");
    }
}
