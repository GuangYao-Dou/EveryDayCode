package com.dgy.everyday;

import jdk.nashorn.internal.ir.LiteralNode;

/**
 * Date: 2019/9/5
 * Time: 15:47
 * Author: vincent-Dou
 * Description：
 */
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode cur = pHead;
        ListNode cur1 = small;
        ListNode cur2 = big;
        while (cur != null){
            if (cur.val < x){
                ListNode temp = new ListNode(cur.val);
                cur1.next = temp;
                cur1 = cur1.next;
            }else {
                ListNode temp = new ListNode(cur.val);
                cur2.next = temp;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1.next = big.next;
        return small.next;
    }
}
