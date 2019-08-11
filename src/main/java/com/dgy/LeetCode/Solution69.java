package com.dgy.LeetCode;

/**
 * Date: 2019/8/11
 * Time: 15:39
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/sqrtx/
 * x 的平方根
 */
public class Solution69 {
    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++){
            if (i * i == x || ((i * i < x) && ((i+1) * (i+1) > x))){
                return i;
            }
        }
        return 0;
    }
}
