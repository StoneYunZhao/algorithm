package com.zhaoyun.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoyun
 * @Date: 2020/5/15
 */
public final class LT490 {

    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{3, 2};
        System.out.println(new LT490().hasPath(maze, start, destination));
    }

    private int[][] maze;
    private int[] start;
    private int[] destination;
    private int n;
    private int m;
    private Set<Integer> visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        assert maze != null && maze.length > 0 && maze[0].length > 0;
        assert start != null && start.length == 2;
        assert destination != null && destination.length == 2;

        this.maze = maze;
        this.start = start;
        this.destination = destination;
        this.n = maze.length;
        this.m = maze[0].length;
        this.visited = new HashSet<>();

        return hasPath(start[0], start[1]);
    }

    private boolean hasPath(int row, int col) {
        if (visited.contains(getKey(row, col))) {
            return false;
        }

        if (row == destination[0] && col == destination[1]) {
            return true;
        }

        visited.add(getKey(row, col));

        for (int i = 0; i < 4; i++) {
            int drow = directions[i][0];
            int dcol = directions[i][1];

            int curRow = row, curCol = col;
            for (;;) {
                int nextRow = curRow + drow;
                int nextCol = curCol + dcol;

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || maze[nextRow][nextCol] == 1) {
                    if (visited.contains(getKey(curRow, curCol))) {
                        break;
                    }

                    if (hasPath(curRow, curCol)) {
                        return true;
                    }
                    visited.remove(getKey(curRow, curCol));
                    break;
                }

                curRow = nextRow;
                curCol = nextCol;
            }
        }

        return false;
    }

    private int getKey(int row, int col) {
        return row * 100 + col;
    }
}
