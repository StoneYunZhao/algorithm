package com.zhaoyun.leetcode.math;

/**
 * 判断一系列坐标是否为直线
 *
 * @author zhaoyun
 * @Date: 2020/2/8
 */
public final class LT1232 {
    public static void main(String[] args) {
        int[][] cs = new int[][]{{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}};
        System.out.println(new LT1232().checkStraightLine(cs));
    }

    /**
     * 此方法有误差。
     * 优化的方法是：把除法等式变换为乘法等式，做一下数学推导
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        double tol = 0.01;

        double ratio = computeRatio(coordinates[0], coordinates[1]);

        for (int i = 2; i < n; i++) {
            double ratio2 = computeRatio(coordinates[i - 1], coordinates[i]);

            if (Math.abs(ratio2 - ratio) > tol) {
                return false;
            }
        }

        return true;
    }

    private double computeRatio(int[] p1, int[] p2) {
        return ((double) p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
