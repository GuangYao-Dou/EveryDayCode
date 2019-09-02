package com.dgy.NiuKe;

/**
 * Date: 2019/9/2
 * Time: 18:20
 * Author: vincent-Dou
 * Description：
 */
public class NiuKe09021 {
    boolean isSymmetrical(TreeNode pRoot){
        return pRoot == null || isMirror(pRoot.left, pRoot.right);
    }
    public boolean isMirror(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
