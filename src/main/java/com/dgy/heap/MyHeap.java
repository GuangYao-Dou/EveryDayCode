package com.dgy.heap;

/**
 * Date: 2019/7/23
 * Time: 19:09
 * Author: vincent-Dou
 * Description：
 */
public class MyHeap implements IHeap {

    private int[] elem;
    private int usedSize;
    private final int DEFAULT_SIZE = 10;

    public MyHeap(){
        this.elem = new int[DEFAULT_SIZE];
        usedSize = 0;
    }


    public void AdjustDown(int root, int len) {

    }

    public void initHeap(int[] array) {

    }

    public void AdjustUp(int child, int len) {

    }

    public void pushHeap(int item) {

    }

    public int popHeap() {
        return 0;
    }

    public int getHeapTop() {
        return 0;
    }

    public void HeapSort() {

    }

    public void show() {

    }
}
