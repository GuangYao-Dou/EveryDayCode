package com.dgy.everyday;

import java.util.*;

/**
 * Date: 2019/9/9
 * Time: 22:31
 * Author: vincent-Dou
 * Description：关于topK问题
 */
public class TopK{

    int size;
    PriorityQueue<Integer> priorityQueue;

    public TopK(int k){
        this.size = k;
        priorityQueue = new PriorityQueue<Integer> (new Comparator<Integer> () {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void add(int num){
        if (priorityQueue.size() < size) priorityQueue.offer(num);
        if (num > priorityQueue.peek()){
            priorityQueue.poll();
            priorityQueue.add(num);
        }
    }

    public List<Integer> getTopK(){
        List<Integer> list = new ArrayList<>(priorityQueue);
        Collections.sort(list);
        return list;
    }


    public static void main(String[] args) {
        Random random = new Random();
        TopK topK = new TopK(3);
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++){
            int temp = random.nextInt(50);
            arr[i] = temp;
            topK.add(temp);
        }
        Arrays.sort(arr);
        for (int i : arr){
            System.out.printf(i+",");
        }
        System.out.println();
        System.out.println(topK.getTopK());
    }
}
