package com.zhaoyun.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 数组滑动窗口中的最大值
 *
 * @author zhaoyun
 * @Date: 2020/3/16
 */
public final class LT239 {
    /**
     * 优先队列的方式，时间复杂度 O(nlogn)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = queue.peek();
                queue.remove(nums[i - k + 1]);
            }
        }

        return result;
    }

    /**
     * 用双端队列存储下标的方式，时间复杂度 O(n)
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        // 存储下标，只有存储下标才能解决滑动窗口的问题
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekLast() <= i - k) {
                dq.removeLast();
            }

            while (!dq.isEmpty() && nums[i] > nums[dq.peekFirst()]) {
                dq.removeFirst();
            }

            dq.addFirst(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekLast()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-95, 92, -85, 59, -59, -14, 88, -39, 2, 92, 94, 79, 78, -58, 37, 48, 63, -91, 91, 74,
                -28, 39, 90, -9, -72, -88, -72, 93, 38, 14, -83, -2, 21, 4, -75, -65, 3, 63, 100, 59, -48, 43, 35,
                -49, 48, -36, -64, -13, -7, -29, 87, 34, 56, -39, -5, -27, -28, 10, -57, 100, -43, -98, 19, -59, 78,
                -28, -91, 67, 41, -64, 76, 5, -58, -89, 83, 26, -7, -82, -32, -76, 86, 52, -6, 84, 20, 51, -86, 26, 46,
                35, -23, 30, -51, 54, 19, 30, 27, 80, 45, 22};

        int[] res = new LT239().maxSlidingWindow2(test, 10);
        System.out.println(Arrays.toString(res));
    }
}
