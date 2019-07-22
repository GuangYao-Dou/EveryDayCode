package com.dgy.everyday;

import java.util.Scanner;

/**
 * Date: 2019/7/19
 * Time: 13:36
 * Author: vincent-Dou
 * Description：动态规划， 求连续子数组的最大和
 */
public class NiuKe0719 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        String[] strings = str.split(" ");
//        int[] arr = new int[strings.length - 1];
//        for(int i = 1; i < arr.length; i++){
//            arr[i - 1] = Integer.parseInt(strings[i]);
//        }
//        System.out.println(getContinuousArrMaxVal(arr));
        int[] arr = {3, -1, 2, 1};
        System.out.println(getContinuousArrMaxVal(arr));
     }

    public static int getContinuousArrMaxVal(int [] arr){
        if (arr.length <= 0){
            return 0;
        }
        int sum = arr[0];
        int result = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (sum <= 0){
                sum = arr[i];
            }else {
                sum = sum + arr[i];
            }
            if (sum > result){
                result = sum;
            }
        }
        return result;
    }
}
