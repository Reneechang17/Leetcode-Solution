// Hard
// BFS
// Time:O(n^2 * logn), Space:O(n^2)
// https://leetcode.cn/problems/swim-in-rising-water/

import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[] { 0, 0, grid[0][0] });
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            if (vis[x][y])
                continue;
            vis[x][y] = true;

            if (x == n - 1 && y == n - 1)
                return time;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny]) {
                    int nextTime = Math.max(time, grid[nx][ny]);
                    pq.offer(new int[] { nx, ny, nextTime });
                }
            }
        }
        return -1;
    }
}
