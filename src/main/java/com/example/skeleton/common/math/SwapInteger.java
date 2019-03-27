package com.example.skeleton.common.math;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: yebing
 * @Date: 2018-8-28 8:42
 * @Version 1.0.0
 */
public class SwapInteger {

    private Integer a;

    /**
     * 错误的写法.
     * 进行运算符运算时，Integer自动拆装箱，创建了新的对象，对象句柄引向了新的地址
     * @param a
     * @param b
     */
    private void errorSwap(Integer a, Integer b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    /**
     * 正确姿势，利用反射更改地址内的值
     * @param a
     * @param b
     */
    private void correctSwap(Integer a, Integer b){
        int tem=a.intValue();
        Field field= null;
        try {
            field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            //field.set也一样
            field.setInt(a, b);
            field.setInt(b, tem);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String getSpecifiedDayBefore(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);
        String dayBefore=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
        return dayBefore;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Integer a = 1;
        Integer b = 2;
        SwapInteger swapInteger = SwapInteger.class.newInstance();
        System.out.println("Swap之前Integer a:"+a+"   Integer b:"+b);
        swapInteger.correctSwap(a,b);
        System.out.println("Swap之后Integer a:"+a+"   Integer b:"+b);

        System.out.println(getSpecifiedDayBefore("2018-09-15 09:00:00"));
    }
}
