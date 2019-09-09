package com.dgy.everyday;
import	java.math.BigInteger;

/**
 * Date: 2019/9/9
 * Time: 9:59
 * Author: vincent-Dou
 * Description：
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr,10));
    }
    public static boolean binarySearch(int[] arr, int k){
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (arr[mid] == k) return true;
            if (arr[mid] < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return false;
    }
}
