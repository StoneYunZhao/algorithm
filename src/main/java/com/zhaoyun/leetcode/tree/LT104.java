package com.zhaoyun.leetcode.tree;

/**
 * 求二叉树的最大深度
 *
 * Created by ZhaoYun on 2019-05-26
 **/
public final class LT104 {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0, 0);
    }

    private int maxDepth(TreeNode root, int cur, int max) {
        if (root == null) {
            return max;
        }

        max = Math.max(++cur, max);
        return Math.max(maxDepth(root.left, cur, max), maxDepth(root.right, cur, max));
    }
}
