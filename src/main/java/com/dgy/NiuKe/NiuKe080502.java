package com.dgy.NiuKe;

/**
 * Date: 2019/8/5
 * Time: 20:18
 * Author: vincent-Dou
 * Description：判断是否为子树
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class NiuKe080502 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        boolean flag = false;
        if(root1.val==root2.val){
            flag = isSamTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree(root1.left, root2);
            if(!flag){
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private boolean isSamTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSamTree(root1.left, root2.left) && isSamTree(root1.right, root2.right);
        }else{
            return false;
        }


//        if (root1 == null && root2 == null) {
//            return true;
//        }
//        if(root1!=null && root2!=null && root1.val==root2.val){
//            return isSamTree(root1.left, root2.left) && isSamTree(root1.right, root2.right);
//        }else{
//            return false;
//        }
    }
}
