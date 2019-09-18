package com.dgy.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Date: 2019/9/15
 * Time: 19:10
 * Author: vincent-Dou
 * Description：
 */
public class BSTToList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) return pRootOfTree;
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (pRootOfTree != null || !stack.isEmpty()){
            if(pRootOfTree == null){
                pRootOfTree = stack.pop();
                list.add(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            }else {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
        }
        list.get(0).right = list.get(1);
        list.get(0).left = null;
        for (int i = 1; i < list.size() - 1; i++){
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    public static TreeNode convert2(TreeNode root){
        TreeNode head = new TreeNode(-1);
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                cur.right = root;
                root.left = cur;
                cur = cur.right;
                root = root.right;
            }
        }
        head = head.right;
        head.left = null;
        return head;
    }
}
