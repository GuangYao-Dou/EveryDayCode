package com.dgy.LeetCode;

/**
 * Date: 2019/8/12
 * Time: 16:45
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 * 21. 合并两个有序链表
 * 题目描述
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (cur1 != null && cur2 != null){
            if ((cur1.val <= cur2.val)){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        if (cur1 == null){
            cur.next = cur2;
        }else {
            cur.next = cur1;
        }
        return result.next;
    }
}
