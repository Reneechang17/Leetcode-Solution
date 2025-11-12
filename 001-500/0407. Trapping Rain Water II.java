// Hard
// Min Heap???
// Time:O(mn log(mn)),Space:O(mn)
// https://leetcode.cn/problems/trapping-rain-water-ii/

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static class Cell {
        int r, c, h;

        Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m == 0)
            return 0;
        if (n == 0)
            return 0;
        
        if (m < 3 || n < 3)
            return 0;
        
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            vis[i][0] = true;
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            vis[i][n - 1] = true;
        }
        
        for (int j = 0; j < n; j++) {
            if (!vis[0][j]) {
                pq.offer(new Cell(0, j, heightMap[0][j]));
                vis[0][j] = true;
            }
            if (!vis[m - 1][j]) {
                pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
                vis[m - 1][j] = true;
            }
        }

        int water = 0;

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int[] d : DIRS) {
                int nr = cur.r + d[0], nc = cur.c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc])
                    continue;
                vis[nr][nc] = true;

                if (heightMap[nr][nc] < cur.h) {
                    water += cur.h - heightMap[nr][nc];
                }

                pq.offer(new Cell(nr, nc, Math.max(heightMap[nr][nc], cur.h)));
            }
        }
        return water;
    }
}
