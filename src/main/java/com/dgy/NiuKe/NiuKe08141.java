package com.dgy.NiuKe;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/8/14
 * Time: 19:31
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId
 *删除链表中重复的结点
 *
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class NiuKe08141 {
    public static ListNode deleteDuplication(ListNode pHead) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> exist = new ArrayList<>();
        if (pHead == null){
            return pHead;
        }
        ListNode cur1 = pHead;
        while (cur1 != null){
            if (temp.contains(cur1.val)){
                exist.add(cur1.val);
            }else {
                temp.add(cur1.val);
            }
            cur1 = cur1.next;
        }
        ListNode cur2 = new ListNode(-1);
        cur2.next = pHead;
        ListNode cur3 = cur2;
        while (cur3 != null && cur3.next != null){
            if (exist.contains(cur3.next.val)){
                cur3.next = cur3.next.next;
            }else {
                cur3 = cur3.next;
            }
        }
        return cur2.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = deleteDuplication(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
