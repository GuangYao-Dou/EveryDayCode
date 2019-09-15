package com.dgy.LeetCode;

import java.util.Arrays;

/**
 * Date: 2019/9/15
 * Time: 20:27
 * Author: vincent-Dou
 * Description：
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder [postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++){
            if(inorder [i] == postorder [postorder.length - 1]){
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, inorder.length - 1));
            }
        }
        return root;
    }
}
