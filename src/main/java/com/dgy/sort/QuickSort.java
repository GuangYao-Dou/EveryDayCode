package com.dgy.sort;

import java.util.Arrays;

/**
 * Date: 2019/8/16
 * Time: 15:35
 * Author: vincent-Dou
 * Description：快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(20,10);
        System.out.println("排序前：");
        Utils.display(arr);
        System.out.println("排序后：");
        long start = System.nanoTime();
        quickSort1(arr,0, arr.length - 1);
        long end = System.nanoTime();
        Utils.display(arr);
        System.out.println("用时："+(end - start));
    }
    public static void quickSort(int[] arr, int low, int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i = low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    public static void quickSort1(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int i, j, key;
        i = start;
        j = end;
        key = arr[start];
        while (i < j){
            while (i < j && arr[i] <= key) i++;
            while (i < j && arr[j] >= key) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr [j];
        arr[j] = key;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, arr.length - 1);
    }
}
