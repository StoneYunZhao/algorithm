package com.zhaoyun.leetcode.array;

/**
 * 合并两个有序数组
 *
 * @author zhaoyun
 * @Date: 2020/4/7
 */
public final class LT88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }

        assert nums1 != null;

        int cur = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[cur--] = nums1[p1--];
            } else {
                nums1[cur--] = nums2[p2--];
            }
        }

        while (p2 >= 0) {
            nums1[cur--] = nums2[p2--];
        }
    }
}
