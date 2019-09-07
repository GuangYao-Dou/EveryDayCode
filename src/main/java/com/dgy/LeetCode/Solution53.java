package com.dgy.LeetCode;

/**
 * Date: 2019/9/7
 * Time: 20:14
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/maximum-subarray/submissions/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int temp : nums){
            if (sum > 0) sum += temp;
            else sum = temp;
            if (sum > res) res = sum;
        }
        return res;
    }
}
