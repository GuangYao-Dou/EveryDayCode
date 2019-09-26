package com.dgy.everyday;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/9/27
 * Time: 0:11
 * Author: vincent-Dou
 * Description：
 */
public class TestArrSum implements Cloneable{
    static int sum = 0;
    static Object LOCK = new Object();

    public static void main(String[] args) {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        TestArrSum test = new TestArrSum();
        List<Thread> list = new ArrayList<>();
        for (int i = 0, j = 1; i < cpuNum; i++) {
            list.add(new Thread(test.new Sum(j, j + 100 / cpuNum - 1)));
            j = j + 100 / cpuNum;
        }
        list.forEach(temp -> temp.start());
        list.forEach(temp -> {
            try {
                temp.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(sum);
//        TestArrSum test = new TestArrSum();
//        Thread t1 = new Thread(test.new Sum(1,50));
//        Thread t2 = new Thread(test.new Sum(51, 100));
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(sum);
//        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    class Sum implements Runnable {
        int start;
        int end;

        public Sum(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            }
        }
    }
}
