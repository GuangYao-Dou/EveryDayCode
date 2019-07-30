package com.dgy.tree;

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

    public int compar(K a, K b){
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
}
