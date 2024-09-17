// Medium
// Graph, BFS
// O(m * n)
// https://leetcode.com/problems/walls-and-gates/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  private static final int INF = Integer.MAX_VALUE;
  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public void wallsAndGates(int[][] rooms) {
      if (rooms == null || rooms.length == 0) {
          return;
      }
      int row = rooms.length;
      int col = rooms[0].length;
      Queue<int[]> que = new LinkedList<>();

      // 將所有門加入隊列
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (rooms[i][j] == 0) {
            que.offer(new int[] { i, j });
          }
        }
      }

      // 從每個門開始BFS
      while (!que.isEmpty()) {
          int[] point = que.poll();
          int r = point[0];
          int c = point[1];

          // 遍歷四個方向
          for (int[] direction: DIRECTIONS) {
              int newRow = r + direction[0];
              int newCol = c + direction[1];

              // 如果新的位置在網格內，且是一個空房間
              if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && rooms[newRow][newCol] == INF) {
                  // 更新距離為到門的步數
                  rooms[newRow][newCol] = rooms[r][c] + 1;
                  // 將新位置加入隊列，繼續向外擴展
                  que.offer(new int[] {newRow, newCol});
              }
          }
      }
  }
}

/**
 * 牆和門：找到二維網格中每個空房間到最近的門的距離：-1代表牆，不可通行；0代表門；INF代表空房間
 * 更新所有的空房間，使其值變為到最近的門的最短距離，如果房間無法到達任何門，則保持值為INF
 * 
 * 思路：這題可以從每個門開始做BFS，將每個門加入隊列，然後從每個門開始擴展，更新每個空房間的值
 * 為什麼用BFS？因為BFS找出從門開始到最近空房間的最短路徑
 **/