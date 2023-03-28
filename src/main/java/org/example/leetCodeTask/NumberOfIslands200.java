package org.example.leetCodeTask;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200 {
    public class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        count++;
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int[] dir : dirs) {
                                int x = cur[0] + dir[0];
                                int y = cur[1] + dir[1];
                                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == '1') {
                                    visited[x][y] = true;
                                    queue.offer(new int[]{x, y});
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
