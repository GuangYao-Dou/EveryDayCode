package com.dgy.NiuKe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Date: 2019/9/3
 * Time: 20:50
 * Author: vincent-Dou
 * Description：
 */
public class NiuKe0903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String[] strings = s1.split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(strings[i].trim());
            }
            int count = 0;
            Arrays.sort(arr);
            for (int i = 0, j = arr.length - 1; i < j;){
                if (arr[i] + arr[j] < 0){
                    i++;
                }else if (arr[i] + arr[j] > 0){
                    j--;
                }else{
                    i++;
                    j--;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
