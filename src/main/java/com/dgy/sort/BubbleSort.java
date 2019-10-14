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
        long start = System.nanoTime();
        bubbleSort3(arr);
        long end = System.nanoTime();
        System.out.println("排序后");
        Utils.display(arr);
        System.out.println("用时："+(end - start));
    }
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr [j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr [j+1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort3(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
