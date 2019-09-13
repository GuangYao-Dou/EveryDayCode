package com.dgy.LeetCode;

/**
 * Date: 2019/9/13
 * Time: 14:40
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/balanced-binary-tree/
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Solution110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        postSearch(root);
        return flag;
    }

    public int postSearch(TreeNode root) {
        if (root == null) return 0;
        int left = postSearch(root.left);
        int right = postSearch(root.right);
        if (Math.abs(left - right) > 1) flag = false;
        return Math.max(left, right) + 1;
    }

    /**
     *
     * 此函数相当于 return root == null ? 0 : Math.max(getMax(root.left), getMax(root.right)) + 1;
     * @param root
     * @return
     */
    public static int getMax(TreeNode root){
        if(root == null) return 0;
        int left = getMax(root.left);
        int right = getMax(root.right);
        return Math.max(left, right) + 1;
    }
}
