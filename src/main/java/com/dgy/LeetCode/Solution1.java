package com.dgy.LeetCode;

/**
 * Date: 2019/8/11
 * Time: 15:06
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/two-sum/
 *
 * 1. 两数之和
 * 题目描述
 * 评论 (2.6k)
 * 题解(216)New
 * 提交记录
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if ((nums [i] + nums [j]) == target){
                    temp [0] = i;
                    temp [1] = j;
                }
            }
        }
        return temp;
    }
}
