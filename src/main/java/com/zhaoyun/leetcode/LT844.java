package com.zhaoyun.leetcode;

import java.util.Stack;

/**
 * 判断两个编辑序列得到的字符串是否相等
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT844 {
    /**
     * 用栈的方式，空间复杂度 O(n)
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = toStack(S);
        Stack<Character> s2 = toStack(T);

        while (!s1.empty() && !s2.empty()) {
            if (!s1.pop().equals(s2.pop())) {
                return false;
            }
        }

        return s1.empty() && s2.empty();
    }

    private Stack<Character> toStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if ('#' == c) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack;
    }
}
