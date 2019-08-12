package com.dgy.LeetCode;

/**
 * Date: 2019/8/12
 * Time: 16:14
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/middle-of-the-linked-list/description/
 * 876. 链表的中间结点
 * 题目描述
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点
 */
public class Solution876 {
    public static int getIndex(ListNode head){
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count/2 + 1;
    }

    public ListNode middleNode(ListNode head) {
        int index = getIndex(head);
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            if (count == index){
                return cur;
            }else {
                cur = cur.next;
            }
        }
        return null;
    }
    /**
     * 快慢指针法
     */
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
