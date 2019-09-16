package com.dgy.everyday;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2019/9/16
 * Time: 21:26
 * Author: vincent-Dou
 * Description：
 */
public class NiuKe0916 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++){
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int result = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--){
                if(result > 0){
                    result = result - arr[i];
                }else{
                    result = result + arr[i];
                }
            }
            System.out.println(Math.abs(result));
        }
    }
}
