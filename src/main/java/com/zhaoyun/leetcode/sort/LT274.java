package com.zhaoyun.leetcode.sort;

import java.util.Arrays;

/**
 * h 指数计算
 *
 * @author zhaoyun
 * @Date: 2020/2/5
 */
public final class LT274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        if (n == 0 || citations[n - 1] <= 0) {
            return 0;
        }

        if (citations[0] >= n) {
            return n;
        }

        for (int h = n - 1; h > 0; h--) {
            if (citations[n - h] >= h && citations[n - h - 1] <= h) {
                return h;
            }
        }

        return 0;
    }
}
