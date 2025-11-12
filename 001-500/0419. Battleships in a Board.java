// Medium
// DFS
// Time:O(mn), Space:O(m+n)
// https://leetcode.cn/problems/battleships-in-a-board/

class Solution {
  public int countBattleships(char[][] board) {
      int num = 0;
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (board[i][j] == 'X') {
                  num++;
                  dfs(board, i, j);
              }
          }
      }
      return num;
  }
  private void dfs(char[][] board, int i, int j) {
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
          return;
      }
      board[i][j] = '.';
      dfs(board, i - 1, j);
      dfs(board, i + 1, j);
      dfs(board, i, j - 1);
      dfs(board, i, j + 1);
  }
}
