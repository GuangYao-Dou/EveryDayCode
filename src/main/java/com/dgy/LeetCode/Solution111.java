package com.dgy.LeetCode;

import sun.plugin.liveconnect.OriginNotAllowedException;

import javax.security.auth.login.CredentialException;

/**
 * Date: 2019/9/2
 * Time: 16:45
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 */

/**
 * 理解, 在对于没有子树的情况下 那样时不算的比如  1
 *                                           /
 *                                          2
 *  这样时不算右边的, 他的最小深度为2;
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null) return 1 + minDepth(root.left);
        if (root.right != null && root.left == null) return 1 + minDepth(root.right);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
