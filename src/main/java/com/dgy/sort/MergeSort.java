package com.dgy.sort;

import sun.java2d.windows.GDIWindowSurfaceData;

/**
 * Date: 2019/9/2
 * Time: 14:22
 * Author: vincent-Dou
 * Description：
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(20, 8);
        System.out.println("排序前:");
        Utils.display(arr);
        mergeSort(arr);
        System.out.println("排序后:");
        Utils.display(arr);
    }
    //此方法方便调用，可省略
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];//开辟需要的临时数组
        sort(arr, 0, arr.length - 1, temp);
    }
    //分：用递归的方法使一个数组分解到长度为1的序列再调用mege函数
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right)/2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    //治：此函数将两个及以上元素或序列进行合并
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= right) {
            temp[k++] = arr[j++];
        }
        k = 0 ;
        while(left <= right) {
            arr[left++] = temp[k++];
        }
    }

}
