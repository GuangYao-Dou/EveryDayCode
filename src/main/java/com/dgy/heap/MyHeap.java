package com.dgy.heap;

import java.util.Arrays;

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
        this.usedSize = 0;
    }

    public void adjustDown(int root, int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if(child+1 < len && elem[child] < elem[child+1]){
                child++;
            }
            //child肯定是最大值的下标
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }//1 2 3 4 5 6 7 8 9
        //开始调整堆   每一颗子树都需要调整
        for (int i = (elem.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }


    public void pushHeap(int item) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.elem[this.usedSize] = item;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }

    public int popHeap() {
        if(this.usedSize == 0) {
            throw new UnsupportedOperationException("堆为空");
        }
        int temp = elem[0];
        elem[0] = elem[this.usedSize-1];
        elem[this.usedSize-1] = temp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return temp;
    }

    public int getHeapTop() {
        if(this.usedSize == 0) {
            throw new UnsupportedOperationException("堆为空");
        }
        return this.elem[0];
    }

    public void HeapSort() {
        int end = this.usedSize-1;
        while (end > 0) {
            int temp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = temp;
            adjustDown(0, end);
            end--;
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
