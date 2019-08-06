package com.dgy.LeetCode;

/**
 * Date: 2019/8/6
 * Time: 19:15
 * Author: vincent-Dou
 * Description：根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
/*
输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

输出: "1(2(4))(3)"
 */
/*
输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

输出: "1(2()(4))(3)"
 */
public class Solution606 {
    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t == null) {
            return;
        }
        sb.append(t.val);
        if(t.left == null) {
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else{
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }

    public void builderStr(TreeNode root, StringBuilder sb){
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right != null){
            sb.append("()");
            sb.append("(");
            builderStr(root.right, sb);
            sb.append(")");
            return;
        }else if (root.left != null && root.right != null){
            sb.append("(");
            builderStr(root.left, sb);
            sb.append(")");
            sb.append("(");
            builderStr(root.right, sb);
            sb.append(")");
            return;
        }else if (root.left != null && root.right == null){
            sb.append("(");
            builderStr(root.left, sb);
            sb.append(")");
            return;
        }else{
            return;
        }
    }

    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        builderStr(t,sb);
        return sb.toString();
    }
}
