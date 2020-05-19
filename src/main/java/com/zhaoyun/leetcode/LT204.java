package com.zhaoyun.leetcode;

/**
 * 计算小于该值的素数个数
 *
 * Created by ZhaoYun on 2019-05-26
 **/
public final class LT204 {
    public int countPrimes(int n) {
        int count = 0;

        if (n <= 1) {
            return count;
        }

        for (int i = 2; i < n; i++) {
            boolean f = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0 && j != i) {
                    f = false;
                    break;
                }
            }
            if (f) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LT204().countPrimes(499979));
    }
}
