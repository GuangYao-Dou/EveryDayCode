package com.dgy.NiuKe;

import org.w3c.dom.ls.LSException;

import java.awt.datatransfer.FlavorListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2019/8/12
 * Time: 17:06
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?tpId
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class NiuKe081232 {
    public static ListNode partition(ListNode pHead, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode smallCur = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigCur = bigHead;
        while (pHead != null){
            if (pHead.val < x){
                smallCur.next = pHead;
                smallCur = smallCur.next;
            }else {
                bigCur.next = pHead;
                bigCur = bigCur.next;
            }
            pHead = pHead.next;
        }
        bigCur.next = null;
        smallCur.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l4.next = l3;
        l3.next = l2;
        l2.next = l1;
        ListNode temp = partition(l4, 3);
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
