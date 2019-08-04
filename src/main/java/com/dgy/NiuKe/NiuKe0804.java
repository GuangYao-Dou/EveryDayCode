package com.dgy.NiuKe;
import	java.util.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2019/8/4
 * Time: 20:01
 * Author: vincent-Dou
 * Description：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
/*
    void binaryTreesequenceTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null && queue != null){
            if (cur != null){
                queue.offer(cur);
            }
            if (!queue.isEmpty()){
                System.out.println(queue.peek());
                cur = queue.poll().left;
            }
        }
    }
 */
public class NiuKe0804 {
    /**
     * 二叉树的程序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }

    public ArrayList<Integer> pringTopToBottom(TreeNode root){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            arrayList.add(temp.val);
        }
        return arrayList;
    }
}
