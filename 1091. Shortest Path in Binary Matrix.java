// Medium
// BFS
// Time:O(n²), Space:O(n²)
// https://leetcode.cn/problems/shortest-path-in-binary-matrix/

import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        if (n == 1)
            return 1;
        
        // Define 8 dirs
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { 0, 0, 1 }); // row, col, step
        grid[0][0] = 1; // mark as vis
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int row = cur[0], col = cur[1], steps = cur[2];

            if (row == n - 1 && col == n - 1) {
                return steps;
            }

            for (int[] dir : dirs) {
                int nr = row + dir[0], nc = col + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    que.offer(new int[] { nr, nc, steps + 1 });
                    grid[nr][nc] = 1; // mark
                }
            }
        }
        return -1;
    }
}
