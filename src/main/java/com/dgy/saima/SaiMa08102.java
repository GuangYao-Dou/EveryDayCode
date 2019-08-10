package com.dgy.saima;
import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import	java.util.List;

import java.util.Scanner;

/**
 * Date: 2019/8/10
 * Time: 19:38
 * Author: vincent-Dou
 * Description：
 */
public class SaiMa08102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            int len = Integer.parseInt(s1);
            int[] arr = new int [len];
            for (int i = 0; i < len; i++){
                arr[i] = scanner.nextInt();
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < arr.length; i++){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                int temp = arr [i];
                for (int j = i + 1; j < arr.length; j++){
                    if (arr [j] > temp){
                        list.add(arr [j]);
                        temp = arr [j];
                    }
                }
                if (list.size() > result.size()){
                    result = list;
                }
            }
            System.out.println(result);
    }
}
