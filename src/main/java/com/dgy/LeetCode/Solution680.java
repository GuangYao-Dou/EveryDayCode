package com.dgy.LeetCode;

/**
 * Date: 2019/10/31
 * Time: 11:31
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class Solution680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("accdba"));
    }
    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)) return isHuiWen(s, i + 1, j) || isHuiWen(s, i, j - 1);
        }
        return  true;
    }

    public static boolean isHuiWen(String str, int start, int end){
        for (int i = start, j = end; i < j; i++, j--){
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
