package com.zhaoyun.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 因数分解
 *
 * Created by ZhaoYun on 2019-05-24
 **/
public class IntegerFactorization {
    private static List<Integer> res = new ArrayList<>();

    private static void factor(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                factor(x / i);
                factor(i);
                return;
            }
        }
        res.add(x);
    }

    public static void main(String[] args) {
        factor(30);
        System.out.println(res);
    }
}
