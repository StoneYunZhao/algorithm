package com.zhaoyun.leetcode.tree;

/**
 * 求二叉树的最大深度
 * <p>
 * Created by ZhaoYun on 2019-05-26
 **/
public final class LT104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
