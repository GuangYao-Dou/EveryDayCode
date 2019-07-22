package com.dgy.everyday;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2019/7/22
 * Time: 20:41
 * Author: vincent-Dou
 * Description：句子逆序
 *          输入
 *          I am a student
 *          输出
 *          student a am I
 */
public class NiuKe072202 {
    public static void main(String[] args) {
//        String str = "I am a student";
//        System.out.println(stringReserve(str));
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(stringReserve(string));
    }
    public static String stringReserve(String str){
        List<String> list = new LinkedList<String>();
        String temp = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' ' && temp != null){
                list.add(temp);
                temp = "";
            }
            if (i == str.length() - 1  && temp != null){
                list.add(temp);
            }
            if ((str.charAt(i) >= 64 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)){
                temp = temp+Character.valueOf(str.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i --){
            stringBuilder.append(list.get(i)+" ");
        }
        return stringBuilder.toString();
    }
}
