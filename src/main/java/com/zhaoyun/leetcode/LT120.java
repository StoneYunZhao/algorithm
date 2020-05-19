package com.zhaoyun.leetcode;

import java.util.List;

/**
 * 三角形的数组，从顶到底的最短路径
 *
 * @author zhaoyun
 * @Date: 2020/3/23
 */
public final class LT120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[] status = new int[triangle.size()];
        status[0] = triangle.get(0).get(0);

        for (int i = 1; i < status.length; i++) {
            List<Integer> cur = triangle.get(i);
            int pre = status[0];
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    status[j] = status[j] + cur.get(j);
                } else if (j == i) {
                    status[j] = pre + cur.get(j);
                } else {
                    int tmp = pre;
                    pre = status[j];
                    status[j] = Math.min(status[j], tmp) + cur.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int value : status) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
