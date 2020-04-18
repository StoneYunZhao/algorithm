package com.zhaoyun.leetcode.dp;

import java.util.Arrays;
import java.util.Objects;

/**
 * 验证 s3 是否由 s1 s2 交错组成
 * @author zhaoyun
 * @Date: 2020/4/18
 */
public final class LT97 {
    private boolean result = false;

    private char[] s1 = null;
    private char[] s2 = null;
    private char[] s3 = null;
    private int len1 = -1;
    private int len2 = -1;
    private int len3 = -1;

    /**
     * 回溯法
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null) return s1 == null && s2 == null;
        if (s1 == null) return Objects.equals(s2, s3);
        if (s2 == null) return Objects.equals(s1, s3);

        len1 = s1.length();
        len2 = s2.length();
        len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len1 == 0) return Objects.equals(s2, s3);
        if (len2 == 0) return Objects.equals(s1, s3);

        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.s3 = s3.toCharArray();

        backtracking(0, 0, 0);

        return result;
    }

    private void backtracking(int i, int j, int k) {
        if (result) {
            return;
        }

        if (k == len3) {
            result = true;
            return;
        }


        if (i == len1) {
            if (s2[j] == s3[k]) {
                backtracking(i, j + 1, k + 1);
            }
            return;
        }

        if (j == len2) {
            if (s1[i] == s3[k]) {
                backtracking(i + 1, j, k + 1);
            }
            return;
        }

        if (s1[i] != s3[k] && s2[j] != s3[k]) {
            return;
        }

        if (s1[i] == s3[k]) {
            backtracking(i + 1, j, k + 1);
        }

        if (s2[j] == s3[k]) {
            backtracking(i, j + 1, k + 1);
        }
    }

    /**
     * 动态规划法
     * dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符能否交错组成 s3 的前 i + j 个字符
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3 == null) return s1 == null && s2 == null;
        if (s1 == null) return Objects.equals(s2, s3);
        if (s2 == null) return Objects.equals(s1, s3);

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len1 == 0) return Objects.equals(s2, s3);
        if (len2 == 0) return Objects.equals(s1, s3);

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            Arrays.fill(dp[i], false);
            for (int j = 0; j <= len2; j++) {
                int k = i + j;
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k - 1))
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k - 1));
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new LT97().isInterleave("aabcc", "dbbc", "aadbbcbcac"));
    }
}
