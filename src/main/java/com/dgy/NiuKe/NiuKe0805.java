package com.dgy.NiuKe;
import java.util.Arrays;

/**
 * Date: 2019/8/5
 * Time: 19:09
 * Author: vincent-Dou
 * Description： 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */

/**
 * 算法思想： 根据前序遍历和中序遍历的两个数组。在前序遍历的数组中第0号下标位置的值一定是树的根节点
 *           根节点： 一定是前序遍历数组的第0号位置的下标
 *           左子树： 在中序遍历中 和 前序遍历数组0号位置相等的值的左边部分 0， i - 1；
 *           右子树： 在中序遍历中 和 前序遍历数组0号位置相等的值的左边部分 i + 1, arr.length；
 */
/*
     1
    / \
   2   3
    \
     4
     前序遍历：1 2 4 3    //pre
     中序遍历：2 4 1 3    //in
     后序遍历：4 2 3 1    //cur
 */
public class NiuKe0805 {

    /**
     * 此方法是根据后序遍历和中序遍历重建二叉树
     * @param cur
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree2(int[] cur, int[] in){
        if (cur.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(cur [0]);
        for (int i = 0; i < cur.length; i++){
            if (cur[cur.length - 1] == in[i]){
                root.left = reConstructBinaryTree2(Arrays.copyOfRange(cur, 0, i), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree2(Arrays.copyOfRange(cur, i, cur.length - 1), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int[] in) { //pre前序遍历   in中序遍历
        if(pre.length == 0||in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return node;
    }
//    前序遍历：1 2 4 3
//    中序遍历：2 4 1 3
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in){
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre [0]);
        for (int i = 0; i < pre.length; i++){
            if (pre [0] == in[i]){
                root.left = reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree1(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = Arrays.copyOfRange(arr, 1, 3);
        for (int i : ints){
            System.out.println(i);
        }
    }
}
