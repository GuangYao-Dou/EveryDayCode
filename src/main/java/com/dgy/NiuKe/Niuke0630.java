package com.dgy.NiuKe;

/**
 * Date: 2019/6/30
 * Time: 22:21
 * Author: vincent-Dou
 * Description：统计一个数字在排序数组中出现的次数。
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Niuke0630 {
    public static void main(String[] args) {
        int[] arr = {3};
        System.out.println(getIndex(arr, 3));
        System.out.println(GetNumberOfK(arr, 3));
    }
    public static int GetNumberOfK(int [] array , int k) {
        int index = getIndex(array, k);
        if(index == -1){
            return 0;
        }
        int indexTemp = index;
        int count = 0;
        while (indexTemp <= array.length - 1 && array[indexTemp] == k ){
            count++;
            indexTemp++;
        }
        index--;
        while (index >= 0 && array[index] == k){
            count++;
            index--;
        }
        return count;
    }
    public static int getIndex(int[] arr, int num){
        int low = 0;
        int hig = arr.length - 1;
        int mid = 0;
        while (low <= hig){
            mid = (low + hig);
            if (arr[mid] == num){
                return mid;
            }else if(arr[mid] < num){
                low = mid + 1;
            }else if(arr[mid] > num){
                hig = mid - 1;
            }
        }
        return -1;
    }
}
