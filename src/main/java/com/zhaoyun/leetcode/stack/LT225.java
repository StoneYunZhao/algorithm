package com.zhaoyun.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * 可以优化成用一个队列实现：https://leetcode.com/problems/implement-stack-using-queues/discuss/62519/Only-push-is-O(n)-others-are-O(1).-Using-one-queue.-Combination-of-two-shared-solutions
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT225 {

    Queue<Integer> cur = new LinkedList<>();
    Queue<Integer> empty = new LinkedList<>();

    /** Initialize your data structure here. */
    public LT225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        cur.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return exchange();
    }

    /** Get the top element. */
    public int top() {
        int i = exchange();
        cur.add(i);
        return i;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return cur.isEmpty();
    }

    private int exchange() {
        while (true) {
            int i = cur.remove();
            if (cur.isEmpty()) {
                Queue<Integer> tmp = cur;
                cur = empty;
                empty = tmp;
                return i;
            }
            empty.add(i);
        }
    }
}
