package com.zhaoyun.leetcode.tree;

/**
 * 二叉树的公共祖先
 *
 * @author zhaoyun
 * @Date: 2020/3/17
 */
public final class LT236 {

    /**
     * 最快找到两个有效节点
     */
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        low(root, p.val, q.val);
        return result;
    }

    private int low(TreeNode root, int p, int q) {
        if (root == null) {
            return 0;
        }

        if (result != null) {
            return 2;
        }

        int tmp = (root.val == q || root.val == p) ? 1 : 0;

        int c = low(root.left, p, q) + low(root.right, p, q) + tmp;
        if (c == 2 && result == null) {
            result = root;
        }

        return c;
    }

    /**
     * 若本身是其中之一，则结果一定是本身
     * 否则，寻找左右子树各含一个的节点
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
