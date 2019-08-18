package com.dgy.sort;

/**
 * Date: 2019/8/18
 * Time: 11:15
 * Author: vincent-Dou
 * Description：
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(20,10);
        System.out.println("排序前：");
        Utils.display(arr);
        System.out.println("排序后：");
        shellSort(arr);
        Utils.display(arr);
    }
    public static void shellSort(int[] arr){
        for (int i = arr.length / 2; i >= 1; i = i / 2){
            shellSortIn(arr, i);
        }
    }
    public static void shellSortIn(int[] arr, int distance){
        for (int i = distance; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i - distance; j >= 0; j = j - distance){
                if (arr[j] <= temp) break;
                if (arr[j] > temp) arr[j + distance] = arr[j];
            }
            arr[j + distance] = temp;
        }
    }
}
