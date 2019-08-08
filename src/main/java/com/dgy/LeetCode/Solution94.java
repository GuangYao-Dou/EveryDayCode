package com.dgy.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/8/7
 * Time: 16:28
 * Author: vincent-Dou
 * Description： 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution94 {
    //递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        inorderTraversal1(root, list);
        return list;
    }

    public void inorderTraversal1(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        if (root.left != null){
            inorderTraversal1(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal1(root.right, list);
        }
    }

    //非递归实现
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
