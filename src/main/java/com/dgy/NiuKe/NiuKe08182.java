package com.dgy.NiuKe;

import java.util.Scanner;

/**
 * Date: 2019/8/18
 * Time: 16:43
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class NiuKe08182 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int index = scanner.nextInt();
            System.out.println(GetUglyNumber_Solution(index));
        }
    }

    public static int GetUglyNumber_Solution(int index) {
        int count = 0;
        int start = 0;
        while (true){
            if (isUglyNumber(start)) count++;
            if (count == index) return start;
            start++;
        }
    }

    public static boolean isUglyNumber(int num){
        if(num<=0) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        if(num == 1){
            return true;
        }
        return false;
    }
}
