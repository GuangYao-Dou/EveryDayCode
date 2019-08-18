package com.dgy.LeetCode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Date: 2019/8/6
 * Time: 20:10
 * Author: vincent-Dou
 * Description：二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution144 {

    //二叉树前序遍历非递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer> ();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // stack.add(cur);
        while (cur != null || !stack.isEmpty()){
            if (cur == null){
                cur = stack.pop();
            }
            if (cur.right != null){
                stack.add(cur.right);
            }
            result.add(cur.val);
            cur = cur.left;
        }
        return result;
    }


    //二叉树前序遍历递归实现
    public void preorderTraversal1(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        if (root.left != null){
            preorderTraversal1(root.left, list);
        }
        if (root.right != null){
            preorderTraversal1(root.right, list);
        }
    }

    /*
    ==================================0818========================
     */
    List<Integer> nodeList = new ArrayList<>();
    public List<Integer> preorderTraversal0818(TreeNode root) {
        if (root == null) return null;
        nodeList.add(root.val);
        if (root.left != null) preorderTraversal0818(root.left);
        if (root.right != null) preorderTraversal0818(root.right);
        return nodeList;
    }

    public List<Integer> preorderTraversal08182(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> nodeList = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root == null) root = stack.pop();
            if (root.right != null) stack.push(root.right);
            nodeList.add(root.val);
            root = root.left;
        }
        return nodeList;
    }
}
