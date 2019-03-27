package com.example.skeleton.common.math;

/**
 * @Author: yebing
 * @Date: 2018-8-20 16:40
 * @Version 1.0.0
 */
public class StringSort {
    public void swap(String[] array,int left, int right){
        String string = array[left];
        array[left] = array[right];
        array[right] = string;
    }

    public void sort(String[] array, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = array[right].toLowerCase().charAt(0);
        int tail = left-1;
        for(int i=left;i<right;i++){
            if(array[i].toLowerCase().charAt(0)<pivot){
                swap(array,++tail,i);
            }
        }
        swap(array,++tail,right);
        sort(array, left, tail-1);
        sort(array,tail+1,right);
    }

    public static void main(String[] args){
        StringSort stringSort = new StringSort();
        String[] array = {"yyddw","asdas","fewrq","ADFww","sadQa","EdfdA","asdas","ASRRR"};
        stringSort.sort(array,0,7);
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }
    }
}

