package com.dgy.sort;

import sun.util.resources.cldr.es.TimeZoneNames_es_419;

import javax.rmi.CORBA.Util;

/**
 * Date: 2019/8/16
 * Time: 15:13
 * Author: vincent-Dou
 * Description：选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] randomArr = Utils.getRandomArr(20, 10);
        System.out.println("排序前");
        Utils.display(randomArr);
        selectSort2(randomArr);
        System.out.println("排序后：");
        Utils.display(randomArr);
    }
    public static void selectSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++){
            temp = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[temp]) temp = j;
            }
            int tmp = arr[i];
            arr[i] = arr[temp];
            arr[temp] = tmp;
        }
    }

    public static void selectSort1(int[] arr){
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[index] > arr[j]) index = j;
            }
            int temp = arr [index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }


    public static void selectSort2(int[] arr){
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) index = j;
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
