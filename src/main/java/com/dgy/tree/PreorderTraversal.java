package com.dgy.tree;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/9/2
 * Time: 14:41
 * Author: vincent-Dou
 * Description：二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {

    public static List<Integer> preOrder1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(0, root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
            root = root.left;
        }
        return list;
    }
}
