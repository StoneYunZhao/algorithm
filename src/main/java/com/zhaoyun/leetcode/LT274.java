package com.zhaoyun.leetcode;

import java.util.Arrays;

/**
 * h 指数计算
 *
 * @author zhaoyun
 * @Date: 2020/2/5
 */
public final class LT274 {
    /**
     * 先排序
     */
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

    /**
     * 桶排序的方式，这位天才的思路：
     * https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
     */
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int i =0; i< n; i++) {
            buckets[Math.min(n, citations[i])]++;
        }

        int sum = 0;
        for (int h = n; h >= 0; h--) {
            sum += buckets[h];
            if (sum >= h) {
                return h;
            }
        }

        return 0;
    }
}
