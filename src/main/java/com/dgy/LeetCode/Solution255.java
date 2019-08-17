package com.dgy.LeetCode;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2019/8/17
 * Time: 16:06
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class Solution255 {

    Queue<Integer> in;
    Queue<Integer> out;

    /** Initialize your data structure here. */
    public Solution255() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        in.offer(x);
        while (!out.isEmpty()) in.offer(out.poll());
        Queue<Integer> temp = in;
        in = out;
        out = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return out.poll();
    }

    /** Get the top element. */
    public int top() {
        return out.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return out.isEmpty();
    }
}
