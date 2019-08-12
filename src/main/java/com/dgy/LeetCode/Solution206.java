package com.dgy.LeetCode;

/**
 * Date: 2019/8/12
 * Time: 16:02
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/reverse-linked-list/description/
 * 206. 反转链表
 * 题目描述
 * 反转一个单链表
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode temp = null;
        ListNode tmp = null;
        while (cur != null){
            tmp = cur.next;
            cur.next = temp;
            temp = cur;
            cur = tmp;
        }
        return temp;
    }
}
