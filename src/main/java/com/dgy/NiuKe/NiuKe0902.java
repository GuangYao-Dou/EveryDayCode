package com.dgy.NiuKe;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Date: 2019/9/2
 * Time: 17:06
 * Author: vincent-Dou
 * Description：
 */
public class NiuKe0902 {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1 [0] + "  " + num2[0]);
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (map.containsKey(array[i])) {
                map.put(array[i], false);
                continue;
            }
            map.put(array[i], true);
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Boolean> temp = (Map.Entry) iterator.next();
            if (temp.getValue()) list.add(temp.getKey());
        }
        num1 [0] = list.get(0);
        num2 [0] = list.get(1);
    }
}
