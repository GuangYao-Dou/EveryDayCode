package com.dgy.LeetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * Date: 2019/8/17
 * Time: 16:57
 * Author: vincent-Dou
 * Description：https://leetcode-cn.com/problems/min-stack/
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class Solution155 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** initialize your data structure here. */
    public Solution155() {
        stack1 = new Stack<>();
        stack2 = new Stack<> ();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) stack2.push(x);
    }

    public void pop() {
        if (stack1.isEmpty()) return;
        if (stack1.peek().equals(stack2.peek())){
            stack1.pop();
            stack2.pop();
        }else stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) return 0;
        return stack1.peek();
    }

    public int getMin() {
        if (stack2.isEmpty()) return 0;
        return stack2.peek();
    }
}
