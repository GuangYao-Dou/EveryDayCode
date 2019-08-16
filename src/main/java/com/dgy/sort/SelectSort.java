package com.dgy.sort;

import javax.rmi.CORBA.Util;

/**
 * Date: 2019/8/16
 * Time: 15:13
 * Author: vincent-Dou
 * Description：选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] randomArr = Utils.getRandomArr(20, 8);
        System.out.println("排序前");
        Utils.display(randomArr);
        selectSort(randomArr);
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
}
