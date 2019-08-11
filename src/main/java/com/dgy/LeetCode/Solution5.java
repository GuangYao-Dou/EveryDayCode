package com.dgy.LeetCode;

/**
 * Date: 2019/8/11
 * Time: 16:13
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length(), left = 0, right = 0;
        boolean[][] dp = new boolean[len][len];//动态规划一般必不可少的一步就是创建数组，dp[i][j] 表示字符串区间 [i, j] 是否为回文串
        for (int j = 0; j < len; j++) { //注意这里遍历时的 i 和 j 和平常我们遍历的定义刚好是相反的
            for (int i = 0; i <= j; i++) { //这里只需遍历到  i==j 即可，因为 j<i 时根本不存在这样的字串
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > right - left) {//如果是回文字符串，并且比之前的回文字符串要长，更新字符串长度，记录字符串
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
