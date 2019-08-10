package com.dgy.saima;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Date: 2019/8/10
 * Time: 19:03
 * Author: vincent-Dou
 * Description： n^16
 */
public class SaiMa0810 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            int len = Integer.parseInt(s1);
            String strings = scanner.nextLine();
            String[] strings1 = strings.split(" ");
            int[] arr = new int[strings1.length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(strings1[i]);
            }
            int num1 = 0;
            int num2 = 0;
            int difference = Math.abs(arr[0] - arr [1]);
            for (int i = 0; i < arr.length - 1; i++){
                num1 = arr [i];
                num2 = arr [i+1];
                int temp = Math.abs(num1 - num2);
                if (temp < difference){
                    difference = temp;
                    num1 = arr [i];
                    num2 = arr [i+1];
                }
            }
            System.out.println(num1+" "+num2);
        }
    }
}
