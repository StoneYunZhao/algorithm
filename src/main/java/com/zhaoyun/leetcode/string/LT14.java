package com.zhaoyun.leetcode.string;

/**
 * Created by ZhaoYun on 2019-06-19
 **/
public final class LT14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        int index = 0;
        Character cur = null;

        while (true) {

            for (String str : strs) {

                if (str.length() < index + 1) {
                    return res.toString();
                }

                if (cur == null) {
                    cur = str.charAt(index);
                } else {
                    if (str.charAt(index) != cur) {
                        return res.toString();
                    }
                }
            }

            res.append(cur);
            cur = null;
            index++;
        }
    }

}
