package com.dgy.LeetCode;

import com.sun.deploy.net.offline.WIExplorerOfflineHandler;

import java.util.List;

/**
 * Date: 2019/8/12
 * Time: 15:56
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 * 203. 移除链表元素
 * 题目描述
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode test0905(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        dummyHead.next = head;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
