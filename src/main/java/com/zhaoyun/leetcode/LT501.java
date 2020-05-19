package com.zhaoyun.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉查找树中找到出现次数最多的元素
 *
 * @author zhaoyun
 * @Date: 2020/2/7
 */
public final class LT501 {
    /**
     * 把所有元素放在 map 中，然后找到最大出现次数的元素
     */
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        addToMap(root, map);

        int max = Integer.MIN_VALUE;
        Set<Integer> res = new HashSet<>();
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                res.clear();
                res.add(e.getKey());
            } else if (e.getValue() == max) {
                res.add(e.getKey());
            }
        }

        int[] r = new int[res.size()];
        int cur = 0;
        for (int i: res) {
            r[cur++] = i;
        }
        return r;
    }

    private void addToMap(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        addToMap(node.left, map);
        addToMap(node.right, map);
    }
}
