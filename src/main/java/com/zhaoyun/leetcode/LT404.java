package com.zhaoyun.leetcode;

/**
 * 求所有左叶子节点的和
 *
 * Created by ZhaoYun on 2019-05-26
 **/
public final class LT404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && left) {
            return root.val;
        }

        return sum(root.left, true) + sum(root.right, false);
    }
}
