package com.dgy.NiuKe;

/**
 * Date: 2019/8/18
 * Time: 16:31
 * Author: vincent-Dou
 * Description：
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
