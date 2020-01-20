package com.zhaoyun.algorithm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 二分查找变体：查找第一个等于给定值的位置
 * <p>
 * Created by ZhaoYun on 2019-05-24
 **/
public final class BinarySearch2 {
    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = null;
        assertEquals(search(nums, 1), -1);

        nums = new int[]{1};
        assertEquals(search(nums, 1), 0);
        assertEquals(search(nums, 2), -1);

        nums = new int[]{1, 5, 7, 7, 9, 14, 56, 2324};
        assertEquals(search(nums, 2), -1);
        assertEquals(search(nums, 7), 2);
    }
}
