package com.dgy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/9/2
 * Time: 14:48
 * Author: vincent-Dou
 * Description：
 */
public class InOrderTraversal {

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.add(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
