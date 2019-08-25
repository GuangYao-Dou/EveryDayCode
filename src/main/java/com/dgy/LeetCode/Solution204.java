package com.dgy.LeetCode;

/**
 * Date: 2019/8/25
 * Time: 22:37
 * Author: vincent-Dou
 * Description：
 */
public class Solution204 {
    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(10));
        System.out.println(isprimeNumber(1));
    }
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++){
            if (isprimeNumber(i)) count++;
        }
        return count;
    }
    public static boolean isprimeNumber(int num){
        boolean flag = true;
        for (int i = 2; i < num; i++){
            if (num % i == 0) flag = false;
        }
        return flag;
    }
}
