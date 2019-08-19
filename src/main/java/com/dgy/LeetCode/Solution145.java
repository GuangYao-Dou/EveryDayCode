package com.dgy.LeetCode;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import org.apache.ibatis.parsing.XNode;

import java.util.*;

/**
 * Date: 2019/8/19
 * Time: 10:23
 * Author: vincent-Dou
 * Description：二叉树的后序遍历
 */
public class Solution145 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
            list.add(0, temp.val);
        }
        return list;
    }
}