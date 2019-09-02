package com.dgy.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2019/9/2
 * Time: 16:26
 * Author: vincent-Dou
 * Description：
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }

    public static int maxDepth1(TreeNode root){
        int depth = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
                count--;
            }
            depth++;
        }
        return depth;
    }
}
