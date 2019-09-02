package com.dgy.LeetCode;

/**
 * Date: 2019/9/2
 * Time: 18:32
 * Author: vincent-Dou
 * Description：
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
