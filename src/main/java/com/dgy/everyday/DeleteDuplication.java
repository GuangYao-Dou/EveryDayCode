package com.dgy.everyday;
import java.util.*;

import jdk.nashorn.internal.ir.LiteralNode;
import org.omg.CORBA.INTERNAL;
import sun.awt.image.ImageWatched;

import java.beans.PropertyEditorSupport;

/**
 * Date: 2019/9/5
 * Time: 16:17
 * Author: vincent-Dou
 * Description：
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        ListNode cur = pHead;
        while (cur != null){
            if (list.contains(cur.val)){
                temp.add(cur.val);
            }else {
                list.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode result = new ListNode(-1);
        result.next = pHead;
        cur = result;
        while (cur != null && cur.next != null){
            if (temp.contains(cur.next.val)){
                cur.next = cur.next.next;
            }else {
                cur = cur = cur.next;
            }
        }
        return result.next;
    }
}
