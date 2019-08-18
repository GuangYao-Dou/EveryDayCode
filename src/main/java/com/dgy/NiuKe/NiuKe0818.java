package com.dgy.NiuKe;

/**
 * Date: 2019/8/18
 * Time: 16:31
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class NiuKe0818 {
    public void Mirror(TreeNode root) {
        mirror(root);
    }
    public TreeNode mirror(TreeNode root){
        if (root == null) return null;
        TreeNode rootLeft = root.left;
        root.left = mirror(root.right);
        root.right = mirror(rootLeft);
        return root;
    }
}
