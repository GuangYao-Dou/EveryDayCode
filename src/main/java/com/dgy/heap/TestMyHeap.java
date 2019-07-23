package com.dgy.heap;

/**
 * Date: 2019/7/23
 * Time: 23:33
 * Author: vincent-Dou
 * Description：
 */
public class TestMyHeap {
    public static void main(String[] args) {
        MyHeap testHeap = new MyHeap();
        int[] array = {1,2,3,4,5,6,7,8,9};
        testHeap.initHeap(array);
        testHeap.show();
        testHeap.pushHeap(10);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        testHeap.HeapSort();
        testHeap.show();
    }
}
