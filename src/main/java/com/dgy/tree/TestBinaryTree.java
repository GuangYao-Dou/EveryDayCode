package com.dgy.tree;

import sun.reflect.generics.tree.Tree;

import javax.management.QueryEval;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * Date: 2019/7/27
 * Time: 21:14
 * Author: vincent-Dou
 * Description：
 */
public class TestBinaryTree {

    class TreeNode {
        char val;//数据值
        TreeNode left;//存储左孩子的引用
        TreeNode right;//存储右孩子的引用
        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right);
        }
    }
    public int i = 0;//遍历字符串
    //根据字符串创建二叉树 ABC##DE#G##F###
    TreeNode createTestTree(String s){
        TreeNode root = null;
        if(s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        }else{
            i++;
        }
        return root;
    }

    //二叉树的前序遍历  递归
    void binaryTreePrevOrder(TreeNode root){
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }
    //二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root){
        if(root == null) {
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val+" ");
        binaryTreeInOrder(root.right);
    }
    //二叉树的后序遍历
    void binaryTreePostOrder(TreeNode root){
        if(root == null) {
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val+" ");
    }
    // 结点个数
    int getSize(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }

    // 叶子结点个数
    int getLeafSize(TreeNode root){
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right==null) {
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k){
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1)
                +getKLevelSize(root.right,k-1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树
    // 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, int value){
        return null;
    }
    //二叉树的高度
    int height(TreeNode root){
        /*if(root == null) {
            return 0;
        }else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return (leftHeight > rightHeight ?
                    leftHeight : rightHeight)+1;
        }*/
        if(root == null) {
            return 0;
        }else {
            //int leftHeight = height(root.left);
            //int rightHeight = height(root.right);
            return (height(root.left) > height(root.right) ?
                    height(root.left) : height(root.right))+1;
        }
    }

    //先序遍历
    void binaryTreePrevOrderNonR(TreeNode root){

    }

    //中序遍历
    void binaryTreeinOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            System.out.println(cur.val);
            cur = stack.pop().right;
        }
    }

    //后序遍历
    void binaryTreesubsequentTraversal(TreeNode root){

    }

    //层序遍历
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

    //判断是否完全二叉树
    boolean isCompleteBinaryTree(TreeNode root){
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        while (cur != null || queue.poll() != null){
            queue.offer(cur.left);
            queue.offer(cur.right);
//            if (cur.left != null){
//                cur = cur.left;
//            }else {
//                cur = cur.right;
//            }
//            queue.peek();
            cur = queue.peek();
        }
        for (TreeNode temp : queue){
            if (temp != null){
                return false;
            }
        }
        return true;
    }

    //领扣的某个题100
    public boolean isSameTree(TreeNode tree1, TreeNode tree2){
        TreeNode cur1 = tree1;
        TreeNode cur2 = tree2;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        while (cur1 != null && cur2 != null){
            queue1.offer(cur1.left);
            queue1.offer(cur1.right);
            queue2.offer(cur2.left);
            queue2.offer(cur2.right);
            cur1 = queue1.peek();
            cur2 = queue2.peek();
            if (!cur1.equals(cur2)){
                return false;
            }
        }
        return true;
    }

    //领扣572
    //二叉树的前序遍历  递归
//    void binaryTreePrevOrder(TreeNode root){
//        if(root == null) {
//            return;
//        }
//        System.out.print(root.val+" ");
//        binaryTreePrevOrder(root.left);
//        binaryTreePrevOrder(root.right);
//    }

    //领扣的某个题
    public boolean isContainTree(TreeNode parent, TreeNode son){
        if (parent == null && son == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = parent;
        while (cur != null && queue != null){
            if (cur != null){
                queue.offer(cur);
            }
            if (!queue.isEmpty()){
                boolean flag = isSameTree(cur, son);
                if (flag){
                    return true;
                }
                cur = queue.peek().left;
            }
        }
        return false;
    }













}
