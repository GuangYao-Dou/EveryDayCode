package com.dgy.saima;
import java.util.*;

import static java.util.Arrays.sort;

/**
 * Date: 2019/8/9
 * Time: 17:01
 * Author: vincent-Dou
 * Description：https://exercise.acmcoder.com/online/online_judge_ques?ques_id=3374&konwledgeId=41
 * <p>
 * 给你两个集合，要求 {A} + {B}。
 * <p>
 * 注：同一个集合中不会有两个相同的元素。
 */
public class SaiMa0809 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int s1len = scanner.nextInt();
            int s2len = scanner.nextInt();
            Set<Integer> set1 = new HashSet<Integer>();
            Set<Integer> set2 = new HashSet<Integer>();
            for (int i = 0; i < s1len; i++) {
                set1.add(scanner.nextInt());
            }
            for (int i = 0; i < s2len; i++) {
                set2.add(scanner.nextInt());
            }
            Set<Integer> result = new HashSet<Integer>();
            for (int temp : set1) {
                result.add(temp);
            }
            for (int temp : set2) {
                result.add(temp);
            }
            Object[] objects = result.toArray();
            int[] arr = new int[objects.length];
            for (int i = 0; i < arr.length; i++){
                arr [i] = (int) objects [i];
            }
            Arrays.sort(arr);
            for (int temp : arr){
                System.out.println(temp+" ");
            }
            System.out.println();
        }
    }
}
