package com.dgy.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2019/8/10
 * Time: 11:04
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/interview/1/
 */
public class LeetCode0810 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if(nums1 != null){
            for(int temp : nums1)
                list.add(temp);
        }
        if(nums2 != null){
            for(int temp : nums2){
                list.add(temp);
            }
        }
        Object[] obs = list.toArray();
        int[] arr = new int[obs.length];
        for (int i = 0; i < arr.length; i++){
            arr [i] = (int) obs [i];
        }
        Arrays.sort(arr);
        if (arr.length % 2  == 0){
            return (double)(arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        }else {
            return (double) arr[arr.length / 2] / 1.0;
        }
    }
}
