package com.zhaoyun.leetcode;

/**
 * 判断是否为二叉查找树
 *
 * @author zhaoyun
 * @Date: 2020/3/17
 */
public final class LT98 {

    /**
     * 中序遍历，记录上一个节点
     */
    private Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (prev != null && root.val <= prev) {
            return false;
        }

        prev = root.val;
        return isValidBST(root.right);
    }

    /**
     * 记录当前节点的左右边界值
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (left != null && val <= left) return false;
        if (right != null && val >= right) return false;

        return valid(root.left, left, val) && valid(root.right, val, right);
    }
}
