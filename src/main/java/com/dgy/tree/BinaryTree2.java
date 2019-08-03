package com.dgy.tree;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/7/29
 * Time: 18:42
 * Author: vincent-Dou
 * Description：
 */
public class BinaryTree2 {
    class TreeNode {
        char val;//数据值
        TreeNode left;//存储左孩子的引用
        TreeNode right;//存储右孩子的引用
        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isSymmetricChile(root.left, root.right);
    }
    public boolean isSymmetricChile(TreeNode treeLeft, TreeNode treeRigth){
        if (treeLeft == null && treeRigth == null){
            return true;
        }
        if (treeLeft != null && treeRigth != null && treeLeft.val == treeRigth.val
                && treeLeft.left.val == treeRigth.right.val && treeLeft.right.val == treeRigth.left.val){
            return true;
        }
        return false;
    }


    //
    public void tree2strCild(TreeNode t, StringBuilder sb){
        if (t == null){
            return;
        }
        sb.append(t.val);
        if (t.left == null){
            if (t.right == null){
                return;
            }else {
                sb.append("()");
            }
        }else {
            if (t.right == null){
                return;
            }else {
                sb.append("(");
                sb.append(t.val);
                sb.append(")");
                t = t.left;
                tree2strCild(t, sb);
            }
        }
    }


    //后续遍历
    void binaryTreePostOrder(TreeNode root, List<TreeNode> list){
        if(root == null) {
            return;
        }
        TreeNode cur = root;
        binaryTreePostOrder(cur.left, list);
        binaryTreePostOrder(cur.right, list);
        list.add(cur);
//        System.out.print(root.val+" ");
    }

    public boolean isContains(TreeNode root, TreeNode p){
        TreeNode cur = root;
        while (cur != null){
            if (cur.val == p.val && cur.left == p.left && cur.right == p){
                return true;
            }
            isContains(cur.left, p);
            isContains(cur.right, p);
        }
        return false;
    }


    public TreeNode test(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> list = new ArrayList<>();
        binaryTreePostOrder(root, list);
        for (TreeNode temp : list){
            TreeNode cur = temp;
            int flag = 0;
            while (cur != null){
                if (isContains(cur, q)){
                    flag++;
                }else {

                }
            }
        }
        return null;
    }

    //牛客
    public void converTree(TreeNode cur){
        if (cur == null){
            return;
        }
        TreeNode prev = null;
        converTree(cur.left);
        cur.left = prev;
        prev.right = cur;
        cur = cur.right;
        converTree(cur.right);
    }
}
