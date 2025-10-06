// Medium
// BFS
// Time:O(mn*log(mn)), Space:O(mn)
// https://leetcode.cn/problems/path-with-minimum-effort/

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 0 }); // [x, y, effort]
        dist[0][0] = 0;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], e = cur[2];

            if (x == m - 1 && y == n - 1)
                return e;

            if (e > dist[x][y])
                continue;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int ne = Math.max(e, Math.abs(heights[nx][ny] - heights[x][y]));

                    if (ne < dist[nx][ny]) {
                        dist[nx][ny] = ne;
                        pq.offer(new int[] { nx, ny, ne });
                    }
                }
            }
        }
        return -1;
    }
}
