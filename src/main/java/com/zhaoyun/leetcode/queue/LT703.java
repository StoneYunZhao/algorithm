package com.zhaoyun.leetcode.queue;

import java.util.PriorityQueue;

/**
 * 返回数据流中第 k 大元素
 *
 * @author zhaoyun
 * @Date: 2020/3/16
 */
public final class LT703 {

    private PriorityQueue<Integer> q;
    private int k;

    public LT703(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>((a, b) -> a - b);

        for (int i: nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.add(val);
        } else {
            if (q.peek() < val) {
                q.poll();
                q.add(val);
            }
        }
        return q.peek();
    }
}
