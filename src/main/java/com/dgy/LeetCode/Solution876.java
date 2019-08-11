package com.dgy.LeetCode;

/**
 * Date: 2019/8/11
 * Time: 15:10
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/transpose-matrix/
 * 867. 转置矩阵
 * 题目描述
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */

public class Solution876 {
    public int[][] transpose(int[][] A) {
        if (A.length == 0){
            return new int[0][0];
        }
        int[][] arr = new int[A[0].length][A.length];
        for(int i = 0; i < A[0].length; i++){//列
            for(int j = 0; j < A.length; j++){//行
                arr[i][j] = A[j][i];
            }
        }
        return arr;
    }
}
