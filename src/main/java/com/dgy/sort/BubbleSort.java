package com.dgy.sort;

import java.util.Random;

/**
 * Date: 2019/8/16
 * Time: 14:48
 * Author: vincent-Dou
 * Description：冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(20, 10);
        System.out.println("排序前：");
        Utils.display(arr);
        bubbleSort(arr);
        System.out.println("排序后");
        Utils.display(arr);
    }
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        int temp;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
