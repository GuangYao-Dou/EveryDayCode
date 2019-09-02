package com.dgy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/9/2
 * Time: 14:58
 * Author: vincent-Dou
 * Description：二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 */
public class PostOrderTraversal {
    public static List<Integer> postOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(0, root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return list;
    }
}
