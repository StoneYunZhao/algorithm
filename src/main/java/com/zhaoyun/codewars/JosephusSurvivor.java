package com.zhaoyun.codewars;

/**
 * https://www.codewars.com/kata/555624b601231dc7a400017a
 *
 * @author zhaoyun
 * create at 2019/11/26 19:14
 */
public final class JosephusSurvivor {
    public static int josephusSurvivor(final int n, final int k) {
        final var marks = new boolean[n];

        var left = n;
        var cur = 0;
        var skipped = 0;
        var t = 0;

        while (left > 1) {
            t = cur % n;
            if (!marks[t] && ++skipped == k) {
                marks[t] = true;
                skipped = 0;
                left--;
            }
            cur++;
        }

        for (int i = 0; i < marks.length; i++) {
            if (!marks[i]) {
                return i + 1;
            }
        }

        throw new RuntimeException();
    }
}
