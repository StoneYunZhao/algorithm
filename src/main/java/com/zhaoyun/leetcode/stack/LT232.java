package com.zhaoyun.leetcode.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT232 {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public LT232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transfer();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        transfer();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();
    }

    private void transfer() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }
}
