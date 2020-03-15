package com.zhaoyun.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断字符串括号是否匹配
 *
 * @author zhaoyun
 * @Date: 2020/3/15
 */
public final class LT20 {

    private Map<Character, Character> pairs = new HashMap<>();
    {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();

        for (char c: cs) {
            if (pairs.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
