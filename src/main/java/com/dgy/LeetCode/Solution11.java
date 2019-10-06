package com.dgy.LeetCode;

/**
 * Date: 2019/10/6
 * Time: 9:20
 * Author: vincent-Dou
 * Description：
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端
 * 点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int temp = (j - i) * Math.min(height[i], height[j]);
                if(temp > result){
                    result = temp;
                }
            }
        }
        return result;
    }

    public int maxArea2(int[] height) {
        int result = 0;
        for(int i = 0, j = height.length - 1; i < j; ){
            int temp = (j - i) * Math.min(height [i], height [j]);
            if (temp > result) result = temp;
            if(height [j] < height [i]){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }
}
