package com.dgy.NiuKe;
import	java.util.Scanner;
import java.lang.Math;
/**
 * Date: 2019/8/9
 * Time: 9:51
 * Author: vincent-Dou
 * Description：求数列的和
 */
public class Test0809 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int n = Integer.parseInt(strings [0]);
        int m = Integer.parseInt(strings [1]);
        double result = 0;
        double temp = 0;
        for (int i = 0; i < m; i++){
            if (i == 0){
                temp = Double.parseDouble(strings [0]);
            }else {
                temp = Math.pow(temp,0.5);
            }
            result  = result + temp;
        }
        System.out.println(String.format("%.2f",result));
    }
}
