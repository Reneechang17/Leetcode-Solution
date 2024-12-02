// Medium
// DFS
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/surrounded-regions/

class Solution {
  // Check the boundary, mark all O and its connected O as B
  public void solve(char[][] board) {
      // basecase
      if (board == null || board.length == 0) return;

      int row = board.length, col = board[0].length;
      for (int i = 0; i < row; i++) {
          dfs(board, i, 0); // left boundary
          dfs(board, i, col - 1); // right boundary
      }
      for (int j = 0; j < col; j++) {
          dfs(board, 0, j); // top boundary
          dfs(board, row - 1, j); // bottom boundary
      }

      // iterate the board, mark all O as X, and B as O
      for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
              if (board[i][j] == 'O') {
                  board[i][j] = 'X';
              } else if (board[i][j] == 'B') {
                  board[i][j] = 'O';
              }
          }
      }
  }

  private void dfs(char[][] board, int i, int j) {
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
          return;
      }
      board[i][j] = 'B';
      dfs(board, i - 1, j);
      dfs(board, i + 1, j);
      dfs(board, i, j - 1);
      dfs(board, i, j + 1);
  }
}
