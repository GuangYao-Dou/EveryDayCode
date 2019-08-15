package com.dgy.LeetCode;

/**
 * Date: 2019/8/15
 * Time: 18:17
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/linked-list-cycle-ii/description/
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;

        fast = slow;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
