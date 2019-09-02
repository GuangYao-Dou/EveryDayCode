package com.dgy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2019/9/2
 * Time: 15:04
 * Author: vincent-Dou
 * Description：二叉树的层序遍历
 *https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/
 */
public class SequenceTraversal {
    public static List<List<Integer>> Sequence(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
                list.add(root.val);
                count--;
            }
            result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> Sequence1(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
                list.add(root.val);
                count--;
            }
            result.add(list);
        }
        return result;
    }
}
