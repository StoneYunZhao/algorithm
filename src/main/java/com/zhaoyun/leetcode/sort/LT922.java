package com.zhaoyun.leetcode.sort;

/**
 * 排列数组，使偶数在偶数位置，奇数在奇数位置
 *
 * @author zhaoyun
 * @Date: 2020/2/6
 */
public final class LT922 {

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;
        boolean findI = true;
        while (i < n && j < n) {
            if (findI) {
                if (A[i] % 2 == 1) {
                    findI = false;
                } else {
                    i += 2;
                }
            } else {
                if (A[j] % 2 == 0) {
                    findI  = true;
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                } else {
                    j += 2;
                }
            }
        }

        return A;
    }
}
