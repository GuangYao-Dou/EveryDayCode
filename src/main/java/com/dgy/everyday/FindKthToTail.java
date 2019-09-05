package com.dgy.everyday;

/**
 * Date: 2019/9/5
 * Time: 15:11
 * Author: vincent-Dou
 * Description：
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0){
            fast = fast.next;
            k--;
        }
        if (k != 0) return null;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
