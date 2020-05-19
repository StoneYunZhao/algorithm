package com.zhaoyun.leetcode;

import java.util.Arrays;

/**
 * 从一个数组中，找出三个数，能够组成三角形，最大周长
 *
 * @author zhaoyun
 * @Date: 2020/2/6
 */
public final class LT976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;

        for (int i = n -1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i - 1] + A[i - 2] + A[i];
            }
        }

        return 0;
    }
}
