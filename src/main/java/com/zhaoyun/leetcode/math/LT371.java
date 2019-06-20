package com.zhaoyun.leetcode.math;

/**
 * 不用 + - 计算两整数之和
 * Created by ZhaoYun on 2019-06-20
 **/
public final class LT371 {
    public int getSum(int a, int b) {
        int c = a & b, d = a ^ b;
        return c == 0 ? d : getSum(c << 1, d);
    }
}
