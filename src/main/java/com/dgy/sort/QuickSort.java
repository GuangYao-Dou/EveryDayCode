package com.dgy.sort;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

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
    public static void quickSort(int[] arr, int start, int end){
        if (start > end) return;
        int i = start;
        int j = end;
        int key = arr[start];
        while (i < j){
            while (i < j && arr[j] >= key) j--;
            while (i < j && arr[i] <= key) i++;
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr[i];
        arr[i] = key;
        quickSort(arr, start, i-1);
        quickSort(arr, i + 1, end);
    }

    public static void quickSort1(int [] arr, int start, int end) {
        if (start > end) return;
        int i = start;
        int j = end;
        int key = arr[start];
        while (i < j){
            while (i < j && arr[j] >= key) j--;
            while (i < j && arr[i] <= key) i++;
            if (i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[i];
        arr[i] = key;
        quickSort1(arr, 0, i - 1);
        quickSort(arr, i + 1, end);
    }

    public void quickSort1211(int[] arr, int start, int end){
        if(start > end) return;
        int key = arr[start];
        int i = start;
        int j = end;
        while (i < j){
            while (i < j && arr[j] >= key) j--;
            while (i < j && arr[i] <= key) i++;
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            arr[start] = arr[i];
            quickSort1211(arr, 0, i - 1);
            quickSort1211(arr, i+1, end);
        }
    }
}
