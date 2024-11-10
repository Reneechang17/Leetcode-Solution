// Medium
// Matrix
// O(mn)
// https://leetcode.cn/problems/game-of-life/

class Solution {
  public void gameOfLife(int[][] board) {
      int m = board.length;
      int n = board[0].length;

      // 定义方向数组，表示八个方向
      int[] directions = {-1, 0, 1};

      // 遍历每个细胞
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              int liveNeighbors = 0;

              // 计算当前细胞的活邻居数
              for (int dx : directions) {
                  for (int dy : directions) {
                      if (dx == 0 && dy == 0) continue; // 跳过自身

                      int x = i + dx;
                      int y = j + dy;

                      // 检查是否在边界内，且邻居之前是活的（状态1或2）
                      if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] & 1) == 1) {
                          liveNeighbors++;
                      }
                  }
              }

              // 根据活邻居数确定当前单元的下一状态
              if ((board[i][j] & 1) == 1) { // 当前是活细胞
                  if (liveNeighbors == 2 || liveNeighbors == 3) {
                      board[i][j] |= 2; // 标记该细胞下轮仍活着（10 -> 2）
                  }
              } else { // 当前是死细胞
                  if (liveNeighbors == 3) {
                      board[i][j] |= 2; // 标记该细胞下轮将复活（01 -> 10）
                  }
              }
          }
      }

      // 更新细胞状态
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              board[i][j] >>= 1; // 使用右移操作更新为下一个状态
          }
      }
  }
}
