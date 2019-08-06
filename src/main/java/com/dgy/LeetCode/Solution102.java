package com.dgy.LeetCode;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2019/8/6
 * Time: 19:48
 * Author: vincent-Dou
 * Description：二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/comments/
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> hierarchicalTraversal(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer> > result = new ArrayList<> ();
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer> ();
            int count = queue.size();
            while (count > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                count--;
            }
            result.add(list);
        }
        return result;
    }
}
