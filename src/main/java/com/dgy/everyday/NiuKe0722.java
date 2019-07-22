package com.dgy.everyday;

import javax.security.auth.SubjectDomainCombiner;
import java.util.Scanner;

/**
 * Date: 2019/7/22
 * Time: 20:05
 * Author: vincent-Dou
 * Description：
 *      输入
 *      hello_world<br/>nice_to_meet_you
 *      输出
 *      helloWorld<br/>niceToMeetYou
 */
public class NiuKe0722 {
    public static void main(String[] args) {
//        String str = "hello_world<br/>nice_to_meet_you";
//        System.out.println(methodNameConvert(str));
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(methodNameConvert(str).equals("helloWorld<br/>niceToMeetYou"));
    }
    public static String methodNameConvert(String oldStr){
        String[] strings = oldStr.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++){
            stringBuilder.append(strings[i].substring(0, 1).toUpperCase()+strings [i].substring(1));
        }
        String result = stringBuilder.substring(0,1).toLowerCase() + stringBuilder.substring(1);
        return result;
    }
}
