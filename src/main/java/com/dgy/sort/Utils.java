package com.dgy.sort;

import java.util.Random;

/**
 * Date: 2019/8/16
 * Time: 15:05
 * Author: vincent-Dou
 * Description：排序工具类
 */
public class Utils {
    private Utils(){}
    public static int[] getRandomArr(int boundary, int amount){
        Random random = new Random();
        int[] arr = new int[amount];
        for (int i = 0; i < amount; i++){
            arr[i] = random.nextInt(boundary);
        }
        return arr;
    }

    public static void display(int[] arr){
        for(int temp : arr){
            System.out.printf(temp + " ");
        }
        System.out.println();
    }
}
