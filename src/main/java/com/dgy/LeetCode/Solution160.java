package com.dgy.LeetCode;

/**
 * Date: 2019/8/14
 * Time: 21:01
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2){
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur1;
    }

    public int getLength(ListNode head){
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int temp = lenA - lenB;
        ListNode curA = headA;
        ListNode curB = headB;
        if (temp < 0){
            for (int i = 0; i < Math.abs(temp); i++)  curB = curB.next;
        }else {
            for (int i = 0; i < temp; i++)  curA = curA.next;
        }
        while (curA != null && curB != null){
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
