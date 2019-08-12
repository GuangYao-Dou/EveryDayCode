package com.dgy.NiuKe;

/**
 * Date: 2019/8/12
 * Time: 16:32
 * Author: vincent-Dou
 * Description：https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class NiuKe08121 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        for (int i =0 ; i < k; i++) {
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 暴力法
     */
    public ListNode FindKthToTail1(ListNode head,int k) {
        int n = getLength(head);
        if(k > n || k < 0){
            return null;
        }
        int len = 0;
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while( count < k){
            fast = fast.next;
            count++;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public  static int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }
}
