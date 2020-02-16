package com.zhaoyun.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 无向图，邻接表的方式实现
 *
 * @author zhaoyun
 * @Date: 2020/2/16
 */
public final class Graph {
    private final int v;
    private final List<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 搜索 s 到 t 的路径，BFS 实现
     */
    public void bfs(int s, int t) {
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        if (s == t) {
            print(prev, t);
        }

        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (queue.size() > 0) {
            Integer p = queue.poll();
            for (int i : adj[p]) {
                if (!visited[i]) {
                    prev[i] = p;
                    if (i == t) {
                        print(prev, t);
                        return;
                    }
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    /**
     * 搜索 s 到 t 的路径，DFS 实现
     */
    public void dfs(int s, int t) {
        final AtomicReference<Boolean> found = new AtomicReference<>(false);

        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);

        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        recurDfs(found, visited, prev, s, t);
        print(prev, t);
    }

    private void recurDfs(AtomicReference<Boolean> found, boolean[] visited, int[] prev, int s, int t) {
        if (visited[s] || found.get()) {
            return;
        }

        if (s == t) {
            found.set(true);
            return;
        }

        visited[s] = true;

        for (Integer i : adj[s]) {
            prev[i] = s;
            recurDfs(found, visited, prev, i, t);
        }
    }

    /**
     * 递归打印路径
     */
    private void print(int[] prev, int t) {
        if (t == -1) {
            return;
        }
        print(prev, prev[t]);
        System.out.println(t + " ");
    }
}
