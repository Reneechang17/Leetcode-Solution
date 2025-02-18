// Medium
// BFS
// Time:O(m*n), Space:O(m*n)
// https://leetcode.cn/problems/rotting-oranges/

import java.util.*;

class Solution {
  // 从所有初始腐烂的橘子出发，计算腐烂扩散到所有新鲜橘子的最短时间->BFS
  public int orangesRotting(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      Queue<int[]> que = new LinkedList<>();
      int fresh = 0;
      // count fresh and add rotten oranges in que
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == 2) {
                  que.offer(new int[]{i, j});
              } else if (grid[i][j] == 1) {
                  fresh++;
              }
          }
      }
      if (fresh == 0) return 0;
      int time = 0;
      int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      while (!que.isEmpty()) {
          int size = que.size();
          boolean hasRotten = false;
          for (int i = 0; i < size; i++) {
              int[] cur = que.poll();
              for (int[] dir : dirs) {
                  int x = cur[0] + dir[0];
                  int y = cur[1] + dir[1];
                  // if occur fresh, make it rotten and add to que
                  if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                      grid[x][y] = 2;
                      que.offer(new int[]{x, y});
                      fresh--;
                      hasRotten = true;
                  }
              }
          }
          // If there are rotting fresh oranges this round, +1 time
          if (hasRotten) time++;
      }
      return fresh == 0 ? time : -1;
  }
}
