package com.dgy.tree;

/**
 * Date: 2019/7/29
 * Time: 18:42
 * Author: vincent-Dou
 * Description：
 */
public class BinaryTree2 {
    class TreeNode {
        char val;//数据值
        TestBinaryTree.TreeNode left;//存储左孩子的引用
        TestBinaryTree.TreeNode right;//存储右孩子的引用
        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
