package com.dgy.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2019/10/31
 * Time: 11:40
 * Author: vincent-Dou
 * Description：
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int line = 0;
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
                if (line % 2 == 0)
                    list.add(root.val);
                else
                    list.add(0, root.val);
                count--;
            }
            result.add(list);
            line++;
        }
        return result;
    }
}
