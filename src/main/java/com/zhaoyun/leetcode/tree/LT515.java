package com.zhaoyun.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 查找树种每一行的最大数
 *
 * @author zhaoyun
 * @Date: 2020/2/8
 */
public final class LT515 {

    /**
     * 直接用 List 存储，效率较高。
     * 亮点在于根据深度扩展列表的长度
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }

        if(d == res.size()){
            res.add(root.val);
        }
        else{
            res.set(d, Math.max(res.get(d), root.val));
        }

        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }

    /**
     * 通过 TreeMap 的方式，生产 map 后还要转换为 list，效率较低
     */
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();

        find(root, map, 1);

        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            res.add(e.getValue());
        }

        return res;

    }

    private void find(TreeNode node, Map<Integer, Integer> map, int depth) {
        if (node == null) return;

        map.put(depth, Math.max(node.val, map.getOrDefault(depth, Integer.MIN_VALUE)));
        find(node.left, map, depth + 1);
        find(node.right, map, depth + 1);
    }
}
