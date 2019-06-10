package com.zhaoyun.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马字符串转整数
 *
 * Created by ZhaoYun on 2019-06-10
 **/
public final class LT13 {
    private static final Map<Character,Integer> dt;

    static {
        dt = new HashMap<>();
        dt.put('I', 1);
        dt.put('V', 5);
        dt.put('X', 10);
        dt.put('L', 50);
        dt.put('C', 100);
        dt.put('D', 500);
        dt.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();

        int sum = 0;
        int first = dt.get(cs[0]), second;
        sum += first;
        for (int i = 1; i < cs.length; i++) {
            second = dt.get(cs[i]);
            sum += second;

            if (second > first) {
                sum -= first * 2;
            }
            first = second;
        }

        return sum;
    }
}
