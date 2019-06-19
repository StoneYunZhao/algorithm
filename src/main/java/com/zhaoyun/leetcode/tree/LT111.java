package com.zhaoyun.leetcode.tree;

/**
 * 二叉树叶子节点的最小深度
 *
 * Created by ZhaoYun on 2019-06-03
 **/
public final class LT111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}