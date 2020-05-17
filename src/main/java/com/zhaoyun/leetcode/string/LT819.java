package com.zhaoyun.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhaoyun
 * @Date: 2020/5/17
 */
public final class LT819 {

    public static void main(String[] args) {
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b = new String[]{"hit"};

        System.out.println(new LT819().mostCommonWord(p, b));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        assert paragraph != null && paragraph.length() > 0;
        assert banned != null;

        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> word2count = new HashMap<>();
        String ret = "";
        for (char c : paragraph.toCharArray()) {
            char lc = lower(c);
            if (isChar(lc)) {
                sb.append(lc);
            } else {
                if (sb.length() == 0) {
                    continue;
                }

                String word = sb.toString();
                sb = new StringBuilder();

                if (ban.contains(word)) {
                    continue;
                }

                int count = word2count.getOrDefault(word, 0) + 1;
                if (count > word2count.getOrDefault(ret, 0)) {
                    ret = word;
                }

                word2count.put(word, count);
            }
        }

        if (sb.length() == 0) {
            return ret;
        }

        String word = sb.toString();
        if (ban.contains(word)) {
            return ret;
        }

        int count = word2count.getOrDefault(word, 0) + 1;
        if (count < word2count.getOrDefault(ret, 0)) {
            ret = word;
        }

        return ret;
    }

    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private char lower(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }

        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }

        return c;
    }
}
