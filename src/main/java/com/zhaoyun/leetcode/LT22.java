package com.zhaoyun.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 生成有效括号组合
 *
 * @author zhaoyun
 * @Date: 2020/3/19
 */
public final class LT22 {

    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        backtrace(n - 1, 1, "(");
        return res;
    }

    private void backtrace(int remain, int left, String cur) {
        if (remain == 0 && left == 0) {
            res.add(cur);
        }

        if (left > 0) {
            backtrace(remain, left - 1, cur + ")");
        }

        if (remain > 0) {
            backtrace(remain - 1, left + 1, cur + "(");
        }
    }

}
