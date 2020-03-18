package com.zhaoyun.leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树按层输出
 *
 * @author zhaoyun
 * @Date: 2020/3/18
 */
public final class LT102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);

        List<List<Integer>> res = new LinkedList<>();
        while (!q1.isEmpty()) {
            List<Integer> r = new LinkedList<>();

            while (!q1.isEmpty()) {
                TreeNode cur = q1.poll();
                r.add(cur.val);

                if (cur.left != null) {
                    q2.add(cur.left);
                }

                if (cur.right != null) {
                    q2.add(cur.right);
                }
            }

            Queue<TreeNode> tmp = q2;
            q2 = q1;
            q1 = tmp;

            res.add(r);
        }

        return res;
    }

}
