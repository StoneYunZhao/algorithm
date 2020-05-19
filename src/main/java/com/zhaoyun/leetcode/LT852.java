package com.zhaoyun.leetcode;

/**
 * 数组中，找到大小关系反转的位置
 *
 * @author zhaoyun
 * @Date: 2020/3/8
 */
public final class LT852 {
    public int peakIndexInMountainArray(int[] A) {
        return search(A, 0, A.length - 1);
    }

    private int search(int[] A, int i, int j) {
        int mid = (i + j) / 2;
        if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
            return mid;
        }
        if (A[mid - 1] < A[mid]) {
            return search(A, mid, j);
        } else {
            return search(A, i, mid);
        }
    }
}
