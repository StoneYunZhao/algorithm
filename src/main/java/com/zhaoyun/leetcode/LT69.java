package com.zhaoyun.leetcode;

/**
 * 求平方根。
 * 一定要注意越界问题。
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT69 {

    public int mySqrt(int x) {
        int low = 0, high = 1 << 16;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                if (x / (mid + 1) < mid + 1) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        new LT69().mySqrt(2147395599);
    }
}
