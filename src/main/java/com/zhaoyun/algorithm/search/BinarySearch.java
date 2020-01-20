package com.zhaoyun.algorithm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 最简单的二分查找，没有重复数据
 *
 * Created by ZhaoYun on 2019-05-24
 **/
public final class BinarySearch {
    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
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

        nums = new int[]{1, 5, 7, 9, 14, 56, 2324};
        assertEquals(search(nums, 2), -1);
        for (int i = 0; i < nums.length; i++) {
            assertEquals(search(nums, nums[i]), i);
        }

    }
}
