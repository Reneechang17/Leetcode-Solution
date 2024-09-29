// Medium
// BFS, Matrix
// O(N^2)
// https://leetcode.cn/problems/shortest-path-in-binary-matrix/

import java.util.*;

class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {
      int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
      int n = grid.length;

      if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
          return -1; // 起點和終點為1則無法通行
      }

      Queue<int[]> que = new LinkedList<>();
      que.offer(new int[] {0, 0, 1}); // {row, col, path_length}

      grid[0][0] = 1; // 已經訪問則為1

      while (!que.isEmpty()) {
          int[] cur = que.poll();
          int row = cur[0], col = cur[1], path_length = cur[2];

          if (row == n - 1 && col == n - 1) {
            return path_length;
          }
          
          // 遍歷八個方向
          for (int[] dir : DIRECTIONS) {
              int newRow = row + dir[0];
              int newCol = col + dir[1];

              // 檢查邊界是否為沒有訪問的1
              if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                  que.offer(new int[] {newRow, newCol, path_length + 1});
                  grid[newRow][newCol] = 1; // 標記為已經訪問
              }
          }
      }
      return -1;
  }
}

/**
 * 二進制矩陣中的最短路徑：這題是經典的BFS問題，要求從左上角到右下角的最短路徑
 * 由於可以向八個方向移動，所以需要在遍歷中考慮這八個方向的路徑，並且需要標記已經訪問的位置
 **/