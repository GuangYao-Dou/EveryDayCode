package com.dgy.NiuKe;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/8/14
 * Time: 20:00
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?tpId
 * 链表的回文结构
 *
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 * 测试样例：
 * 1->2->1
 * 返回：true
 */
public class NiuKe08142 {
    public static boolean chkPalindrome(ListNode A) {
        ListNode cur1 = null;
        ListNode cur2 = A;
        ListNode cur3 = A;
        while (cur3 != null && cur3.next != null){
            cur3 = cur3.next.next;
            ListNode temp = cur2.next;
            cur2.next = cur1;
            cur1 = cur2;
            cur2 = temp;
        }
        if (cur3 != null){
            cur2 = cur2.next;
        }
        while (cur2 != null && cur1 != null){
            if (cur2.val != cur1.val){
                return false;
            }
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        if (cur2 != null || cur1 != null){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n4;
//        n3.next = n4;
        System.out.println(chkPalindrome(n1));
    }
}
