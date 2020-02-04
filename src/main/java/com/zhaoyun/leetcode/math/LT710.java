package com.zhaoyun.leetcode.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 整数序列 [0, N) 中，有一些黑名单数字，排除掉黑名单数字后的剩下数字中随机抽取。
 *
 * 这个人的解法太 6 了：https://leetcode.com/problems/random-pick-with-blacklist/discuss/144624/Java-O(B)-O(1)-HashMap
 * 核心思路是把黑名单数字都挪到最后，然后做一个映射。
 *
 * @author zhaoyun
 * @Date: 2020/2/4
 */
public final class LT710 {
    private final int M;
    private final Map<Integer, Integer> map;
    private final Random r;

    public LT710(int N, int[] blacklist) {
        map = new HashMap<>();
        this.M = N - blacklist.length;

        for (int b: blacklist) {
            map.put(b, b);
        }

        for (int b: blacklist) {
            if (b < M) {
                while (map.containsKey(--N)) { }
                map.put(b, N);
            }
        }

        this.r = new Random();
    }

    public int pick() {
        int i = r.nextInt(M);
        if (map.containsKey(i)) {
            return map.get(i);
        }
        return i;
    }
}
