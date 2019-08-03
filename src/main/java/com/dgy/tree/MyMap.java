package com.dgy.tree;

import sun.awt.SunHints;

import java.util.*;

/**
 * Date: 2019/7/30
 * Time: 9:24
 * Author: vincent-Dou
 * Description：在B站学习的jdk源码剖析之红黑树TreeMap第二节课
 */


public class MyMap<K, V> {

    /**
     * 定义结点
     * @param <K> 键
     * @param <V> 值
     */
    class TreeNode<K, V> implements Map.Entry<K, V>{

        private K key;
        private V value;
        TreeNode<K, V> left;
        TreeNode<K, V> right;

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }

        public TreeNode(K key, V value) {
            this(key, value, null, null);
        }

        public TreeNode(K key, V value, TreeNode<K, V> left, TreeNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "AVLEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode<?, ?> treeNode = (TreeNode<?, ?>) o;

            if (key != null ? !key.equals(treeNode.key) : treeNode.key != null) return false;
            if (value != null ? !value.equals(treeNode.value) : treeNode.value != null) return false;
            if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
            return right != null ? right.equals(treeNode.right) : treeNode.right == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }

    }

    /**
     * 迭代器
     */
    private class MyIterator implements Iterator<TreeNode<K, V>>{

        private Iterator<TreeNode<K, V>> iterator;

        public MyIterator(){
            List<TreeNode<K, V>> list = new ArrayList<>();
            inOrder(root, list);
            iterator = list.iterator();
        }

        //先序遍历
        private void inOrder(TreeNode<K, V> root, List<TreeNode<K, V>> list){
            if (root != null){
                inOrder(root.left, list);
                list.add(root);
                inOrder(root.right, list);
            }
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public TreeNode<K, V> next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }

    /**
     * 取得迭代器
     * @return
     */
    public Iterator iterator(){
        return new MyIterator();
    }



    /**===================================================================================
     * 从此处开始构建相应的属性和方法
     */
    private int size;
    private TreeNode<K, V> root;
    private Comparator<K> comparator;

    private int compar(K a, K b){
        if (comparator != null){
            return comparator.compare(a, b);
        }else {
            Comparable<K> temp = (Comparable<K>) a;
            return temp.compareTo(b);
        }
    }

    public MyMap(){

    }

    public MyMap(Comparator<K> comparator) {
        this.comparator = comparator;
        this.size = 0;
        this.root = null;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //二叉树插入操作
    public V put(K key, V value){
        if (root == null){
            root = new TreeNode<>(key, value);
            size++;
        }else {
            TreeNode<K, V> temp = root;
            while (temp != null){
                int flag = compar(key, temp.key);
                if (flag == 0){
                    temp.setValue(value);
//                    size++;
                    break;
                }else if (flag < 0){
                    if (temp.left == null){
                        temp.left = new TreeNode<>(key, value);
                        size++;
                        break;
                    }else {
                        temp = temp.left;
                    }
                }else if (flag > 0){
                    if (temp.right == null){
                        temp.right = new TreeNode<>(key, value);
                        size++;
                        break;
                    }else {
                        temp = temp.right;
                    }
                }
            }
        }
        return value;
    }

    //关于查找的方法
    public TreeNode<K, V> getEntry(K key){
        TreeNode<K, V> cur = root;
        while (cur != null){
            int temp = compar(cur.getKey(), key);
            if (temp == 0){
                return cur;
            }else if(temp < 0){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean containsKey(K key){
        TreeNode<K, V> temp = getEntry(key);
        return temp != null;
    }

    public V get(K key){
        TreeNode<K, V> temp = getEntry(key);
        return temp == null ? null : temp.getValue();
    }

    public boolean containsValue(V value){
        Iterator<TreeNode< K, V>> iterator = this.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
    //查找key值最小的结点
    public TreeNode<K, V> getMinKeyNode(TreeNode<K, V> temp){
        if (temp == null) {
            return null;
        }
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    //查找key值最大的结点
    public TreeNode<K, V> getMaxKeyNode(TreeNode<K, V> temp){
        if (temp == null) {
            return null;
        }
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    /*BST的删除一个结点
    https://leetcode-cn.com/problems/delete-node-in-a-bst/comments/
        public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
     */
}
















