package com.dgy.LeetCode;

import java.util.Stack;

/**
 * Date: 2019/8/17
 * Time: 16:29
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class Solution232 {

    Stack<Integer> in;
    Stack<Integer> out;
    /** Initialize your data structure here. */
    public Solution232() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()){
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
