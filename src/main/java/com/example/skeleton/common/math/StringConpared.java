package com.example.skeleton.common.math;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * @Author: yebing
 * @Date: 2018-8-21 13:30
 * @Version 1.0.0
 */
public class StringConpared {
    private static Logger logger = Logger.getLogger(StringConpared.class);
    public static void main(String[] args){
        String[] array = {"sd","ww","ad","fv","ww","ad","ad","ff","ff","te"};
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],2);
            }
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("--------我是分割线--------");
        for(Map.Entry<String, Integer> m : map.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
        logger.info("接口方法名:{},跟踪码:{},请求参数{}");
    }
}
