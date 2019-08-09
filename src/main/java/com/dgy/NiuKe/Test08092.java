package com.dgy.NiuKe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2019/8/9
 * Time: 10:26
 * Author: vincent-Dou
 * Description：求水仙花数
 */
public class Test08092 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        List<Integer> list = new ArrayList<>();
        int start = Integer.parseInt(strings [0]);
        int end = Integer.parseInt(strings [1]);
        int temp = 0;
        for (int i = start; i <= end; i++){
            temp = (int)Math.pow((i / 100) % 10, 3) + (int)Math.pow((i / 10) % 10, 3) + (int)Math.pow((i % 10), 3);
            if (temp == i){
                list.add(temp);
            }
        }
        if (list.isEmpty()) {
            System.out.println("no");
        }else {
            for (int i : list){
                System.out.printf(i + " ");
            }
        }
    }
}
