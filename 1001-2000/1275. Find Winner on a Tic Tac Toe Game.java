// Easy
// Simulation
// Time:O(1),Space:O(1), the size of the board is fixed
// https://leetcode.cn/problems/find-winner-on-a-tic-tac-toe-game/

class Solution {
  public String tictactoe(int[][] moves) {
      int[][] board = new int[3][3];
      // simulate the moves
      for (int i = 0; i < moves.length; i++) {
          int row = moves[i][0];
          int col = moves[i][1];
          // Determine the player: A(1) or B(-1)
          board[row][col] = (i % 2 == 0) ? 1 : -1;
          // Check if the cur player has won
          if (checkWin(board, row, col)) {
              return (i % 2 == 0) ? "A" : "B";
          }
      }
      // if no winner, determine the game state
      return moves.length == 9 ? "Draw" : "Pending";
  }

  private boolean checkWin(int[][] board, int row, int col) {
      int player = board[row][col];
      // check the cur row
      if (board[row][0] + board[row][1] + board[row][2] == 3 * player) return true;
      // check the cur col
      if (board[0][col] + board[1][col] + board[2][col] == 3 * player) return true;
      // check the main diagonal
      if (row == col && board[0][0] + board[1][1] + board[2][2] == 3 * player) return true;
      // check the anti-diagonal
      if (row + col == 2 && board[0][2] + board[1][1] + board[2][0] == 3 * player) return true;
      return false;
  }
}
