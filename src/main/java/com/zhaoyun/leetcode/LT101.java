package com.zhaoyun.leetcode;

/**
 * 判断树是否对称
 * <p>
 * Created by ZhaoYun on 2019-06-02
 **/
public final class LT101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
