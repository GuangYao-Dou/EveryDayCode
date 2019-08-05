package com.dgy.LeetCode;

/**
 * Date: 2019/8/5
 * Time: 21:56
 * Author: vincent-Dou
 * Description： 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p!=null && q!=null && p.val==q.val  ){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}
