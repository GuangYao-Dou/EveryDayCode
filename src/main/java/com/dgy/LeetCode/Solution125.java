package com.dgy.LeetCode;

import org.junit.Test;

/**
 * Date: 2019/8/11
 * Time: 14:28
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/valid-palindrome/
 */
//125. 验证回文串
//        示例 1:
//
//        输入: "A man, a plan, a canal: Panama"
//        输出: true
public class Solution125 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        String str = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if ((temp >= 'a' && temp <= 'z') || (temp >= '0' && temp <= '9')){
                stringBuilder.append(temp);
            }
        }
        for (int i = 0, j = stringBuilder.length() - 1; i <= j; i++, j--){
            if (stringBuilder.charAt(i) != stringBuilder.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
