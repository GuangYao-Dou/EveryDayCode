package com.dgy.LeetCode;

import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/9/13
 * Time: 17:25
 * Author: vincent-Dou
 * Description：
 */
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> list = getNodes(s);
        for (TreeNode root : list){
            if (isSame(root, t)) return true;
        }
        return false;
    }

    public static List<TreeNode> getNodes(TreeNode root){
        List<TreeNode> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root == null) root = stack.pop();
            list.add(root);
            if(root.right != null) stack.push(root.right);
            root = root.left;
        }
        return list;
    }

    public static boolean isSame(TreeNode q, TreeNode p){
        if(p == null && q == null) return true;
        if(q == null || p == null) return false;
        if(q.val == p.val){
            return isSame(q.left, p.left) && isSame(q.right, p.right);
        }
        return false;
    }
}
