package com.zhaoyun.leetcode;

/**
 * log(n) 寻找峰值
 *
 * @author zhaoyun
 * @Date: 2020/5/20
 */
public final class LT162 {

    public static void main(String[] args) {
        new LT162().findPeakElement(new int[]{1, 2});
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        int len = nums.length;
        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return 0;
                } else {
                    left = mid + 1;
                }
            } else if (mid == len - 1) {
                if (nums[len - 1] > nums[len - 2]) {
                    return len - 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
