// Medium
// DFS
// Time:O(m*n), Space:O(m*n)
// https://leetcode.cn/problems/minesweeper/

class Solution {
  private int[][] dirs = {
      {-1, 0}, {1, 0}, {0, -1}, {0, 1},
      {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
  };

  public char[][] updateBoard(char[][] board, int[] click) {
      int row = click[0], col = click[1];
      // Case1: click a mine
      if (board[row][col] == 'M') {
          board[row][col] = 'X';
          return board;
      }
      // Case2: click an empty cell
      dfs(board, row, col);
      return board;
  }
  private void dfs(char[][] board, int row, int col) {
      // boundary check and basecase
      if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
          return;
      }
      // count mines around the cur cell
      int mines = countMines(board, row, col);
      if (mines > 0) {
          // update the cell with the number of mines
          board[row][col] = (char)('0' + mines);
      } else {
          // mark as 'B' and continue DFS
          board[row][col] = 'B';
          for (int[] dir : dirs) {
              dfs(board, row + dir[0], col + dir[1]);
          }
      }
  }
  private int countMines(char[][] board, int row, int col) {
      int count = 0;
      for (int[] dir : dirs) {
          int newRow = row + dir[0], newCol = col + dir[1];
          if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == 'M') {
              count++;
          }
      }
      return count;
  }
}
