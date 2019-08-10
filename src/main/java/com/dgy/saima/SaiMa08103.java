package com.dgy.saima;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 2019/8/10
 * Time: 20:01
 * Author: vincent-Dou
 * Description：
 */
public class SaiMa08103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String sum = scanner.nextLine();
            String element =scanner.nextLine();
            String[] elements = sum.split(" ");
            List<List < Integer>> results = new ArrayList<List<Integer>>();
            for (int i = 0; i < elements.length; i++){
                if (getList(results, Integer.parseInt(elements [i])) != -1){
                    int where = getList(results, Integer.parseInt(elements [i]));
                    results.get(where).add(Integer.parseInt(elements [i]));
                }else {
                    List<Integer> list = new ArrayList<Integer> (Integer.parseInt(elements [i]));
                    results.add(list);
                }
            }
            int resultSum = 0;
            for (int i = 0; i < results.size(); i++){
                resultSum = resultSum + results.get(i).size();
            }
            System.out.println(resultSum);
        }
    }

    public static int getList(List<List<Integer>> lists, int num) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(0) == num) {
                return i;
            }
        }
        return -1;
    }
}
