package com.dgy.LeetCode;

/**
 * Date: 2019/12/11
 * Time: 16:58
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/remove-element/submissions/
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
