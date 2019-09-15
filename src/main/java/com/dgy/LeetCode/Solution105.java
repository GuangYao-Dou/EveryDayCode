package com.dgy.LeetCode;

import java.util.Arrays;

/**
 * Date: 2019/9/15
 * Time: 20:00
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder [0]);
        for (int i = 0; i < preorder.length; i++){
            if(preorder[0] == inorder [i]){
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }
}
