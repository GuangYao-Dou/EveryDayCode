package com.dgy.sort;
import org.junit.Test;

import	java.time.Instant;
import java.util.Arrays;

/**
 * Date: 2019/8/18
 * Time: 10:11
 * Author: vincent-Dou
 * Description：
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(20,10);
        System.out.println("排序前：");
        Utils.display(arr);
        System.out.println("排序后");
        insertSort2(arr);
        Utils.display(arr);
    }
    public static void insertSort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (arr[j] <= temp) break;
                if (arr[j] > temp) arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void insertSort1(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (temp >= arr[j]) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void insertSort2(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (temp <= arr[j]) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr)+"   *****");
        }
    }

}
