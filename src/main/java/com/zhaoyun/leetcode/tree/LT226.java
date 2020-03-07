package com.zhaoyun.leetcode.tree;

/**
 * 将二叉树左右反转
 *
 * @author zhaoyun
 * @Date: 2020/3/7
 */
public final class LT226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);

        return root;
    }
}
