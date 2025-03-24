// Hard
// BFS
// Time:O(m² n²), Space:O(m * n)
// https://leetcode.cn/problems/shortest-distance-from-all-buildings/

import java.util.*;

class Solution {
    // Start from each empty land 0, and calculate the total dis to all houses 1
    // If one empty land cannot reach all buildings, mark as invalid
    public int shortestDistance(int[][] grid) {
        int minDis = Integer.MAX_VALUE;
        int rows = grid.length, cols = grid[0].length;
        int total = 0;

        // calculate the num of 1
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    total++;
                }
            }
        }

        // iterate all empty land, calculate the shortest dis
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    minDis = Math.min(minDis, bfs(grid, r, c, total));
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private int bfs(int[][] grid, int startRow, int startCol, int total) {
        int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int rows = grid.length, cols = grid[0].length;
        int totalDis = 0, buildingReached = 0;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { startRow, startCol });

        boolean[][] vis = new boolean[rows][cols];
        vis[startRow][startCol] = true;

        int level = 0;
        while (!que.isEmpty() && buildingReached != total) {
            for (int i = que.size(); i > 0; i--) {
                int[] cur = que.poll();
                int row = cur[0], col = cur[1];

                // if cur is building, add to dis and buildingReached
                if (grid[row][col] == 1) {
                    totalDis += level;
                    buildingReached++;
                    continue;
                }

                // iterate four directions
                for (int[] dir : DIRS) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols) {
                        if (!vis[newRow][newCol] && grid[newRow][newCol] != 2) {
                            vis[newRow][newCol] = true;
                            que.offer(new int[] { newRow, newCol });
                        }
                    }
                }
            }
            level++;
        }
        // if cur empty land cannot reach all buildings, mark all vis path as invalid
        if (buildingReached != total) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 0 && vis[r][c]) {
                        grid[r][c] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return totalDis;
    }
}
