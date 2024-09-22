// Medium
// BFS
// O(n)
// https://leetcode.com/problems/minimum-knight-moves/

import java.util.*;

class Solution {
  private static final int[][] DIRECTIONS = {
          {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
          {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
  };
  public int minKnightMoves(int x, int y) {
      x = Math.abs(x);
      y = Math.abs(y);

      Queue<int[]> que = new LinkedList<>();
      Set<String> visited = new HashSet<>();

      que.offer(new int[] {0, 0});
      visited.add("0, 0");

      int ans = 0;

      while (!que.isEmpty()) {
          int n = que.size();

          for (int i = 0; i < n; i++) {
              int[] cur = que.poll();
              int curX = cur[0], curY = cur[1];

              // 如果找到目標點，直接返回
              if (curX == x && curY == y) {
                  return ans;
              }

              // 繼續擴展下一個訪問點
              for (int[] direction : DIRECTIONS) {
                  int nextX = curX + direction[0], nextY = curY + direction[1];

                  String nextPos = nextX + "," + nextY;

                  // 只有當這個路徑沒有被訪問過時加入
                  if (!visited.contains(nextPos) && nextX >= -2 && nextY >= -2) {
                      que.offer(new int[]{nextX, nextY});
                      visited.add(nextPos);
                  }
              }
          }
          ans++;
      }
      return -1;
  }
}

/**
 * 到達終點的最少移動次數：這題的核心在於求從原點(0,0)走到(x,y)的最少步數
 * 
 * 思路：這題是在所有的可能性中找最少的步數，可以用BFS來找，他能夠返回最少步數的解
 * 剪枝：由於棋盤是對稱的，我們看可以把目標點限制在第一象限，即x>=0, y>=0，這樣可以減少搜索範圍 => 用絕對值來處理
 * 
 * 用隊列來保存當前可以訪問到的座標，並用visited來紀錄是否訪問過，避免重複訪問
 * 每次都從隊列中去取出一個座標，檢查是不是目標點，如果是直接返回；如果不是就繼續擴展下一個訪問點（從DIRECTIONS中選擇）
 * 將沒有訪問過的新座標加入隊列，並標記為已訪問
 **/