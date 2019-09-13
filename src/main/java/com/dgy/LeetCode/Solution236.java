package com.dgy.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/9/13
 * Time: 17:50
 * Author: vincent-Dou
 * Description：
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = getNodes(root);
        for (TreeNode temp : list){
            List<TreeNode> tmp = getNodes(temp);
            if (tmp.contains(p) && tmp.contains(q)) return temp;
        }
        return root;
    }

    public static List<TreeNode> getNodes(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) root = stack.pop();
            list.add(0,root);
            if (root.right != null) stack.push(root.right);
            root = root = root.left;
        }
        return list;
    }
}
