package com.zhaoyun.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaoyun
 * @Date: 2020/5/17
 */
public final class LT937 {

    public static void main(String[] args) {
        String[] logs = new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"};
        new LT937().reorderLogFiles(logs);
    }

    public String[] reorderLogFiles(String[] logs) {
        assert logs != null;

        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        for (String log: logs) {
            String l = parse(log);
            if (l == null) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        letters.sort(Comparator.comparing(this::parse).thenComparing(s -> s));

        String[] ret = new String[logs.length];
        int cur = 0;
        for (String s: letters) {
            ret[cur++] = s;
        }
        for (String s: digits) {
            ret[cur++] = s;
        }

        return ret;
    }


    private String parse(String log) {
        String[] words = log.split(" ");
        char c = words[1].charAt(0);
        if (c >= 'a' && c <= 'z') {
            StringBuilder sb = new StringBuilder(words[1]);
            for (int i = 2; i < words.length; i++) {
                sb.append(" ").append(words[i]);
            }
            return sb.toString();
        }

        return null;
    }
}
