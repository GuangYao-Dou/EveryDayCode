package com.dgy.everyday;

import sun.security.x509.FreshestCRLExtension;

/**
 * Date: 2019/9/7
 * Time: 21:47
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?tpId
 * 题目描述
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 * 1->2->1
 */
public class ChkPalindrome {
    public boolean chkPalindrome(ListNode A) {
        ListNode reverseHead = null;
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = reverseHead;
            reverseHead = slow;
            slow = temp;
        }
        if (fast != null) slow = slow.next;
        while (reverseHead != null && slow != null){
            if (reverseHead.val != slow.val) return false;
            reverseHead = reverseHead.next;
            slow = slow.next;
        }
        return true;
    }
}
