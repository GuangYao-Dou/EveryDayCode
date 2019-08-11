package com.dgy.LeetCode;
import	java.util.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/8/11
 * Time: 14:07
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/valid-parentheses/
 * 20. 有效的括号
 * 题目描述
 * 评论 (993)
 * 题解(132)New
 * 提交记录
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp == '('){
                stack.push(')');
            }else if (temp == '['){
                stack.push(']');
            }else if (temp == '{'){
                stack.push('}');
            }else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)){
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
