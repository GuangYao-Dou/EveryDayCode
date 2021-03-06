package com.dgy.LeetCode;

/**
 * Date: 2019/12/11
 * Time: 17:04
 * Author: vincent-Dou
 * Description：
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] strings = s.trim().split(" ");
        return strings[strings.length - 1].length();
    }

    public int LengthOfLastWord(String s){
        if (s == null || s.length() == 0) return 0;
        boolean hasChar = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (hasChar && s.charAt(i) == ' ') break;
            if (s.charAt(i) != ' ') {
                hasChar = true;
                count++;
            }
        }
        return count;
    }
}
