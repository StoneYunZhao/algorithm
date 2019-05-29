package com.zhaoyun.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth-First-Search
 * <p>
 * Created by ZhaoYun on 2019-05-29
 **/
public final class BFS {
    private void bfs(Tree t) {
        if (t == null) {
            return;
        }

        Queue<Tree> q = new LinkedList<>();
        q.add(t);

        while (q.size() > 0) {
            Tree tmp = q.remove();

            System.out.println(tmp.val);

            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree t = null;
        BFS bfs = new BFS();
        bfs.bfs(t);

        t = new Tree(1);
        t.left = new Tree(2);
        t.right = new Tree(3);

        t.right.right = new Tree(4);
        t.left.right = new Tree(5);

        bfs.bfs(t);
    }
}
