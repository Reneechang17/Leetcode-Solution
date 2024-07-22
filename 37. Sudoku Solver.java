// Hard
// Array, Backtracking
// O(m)
// m是空格的數量
// https://leetcode.com/problems/sudoku-solver/

class Solution {
  public void solveSudoku(char[][] board) {
      solveHelper(board);
  }

  public boolean solveHelper(char[][] board) {
      for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
              if (board[i][j] != '.') {
                  continue;
              }
              // 檢查在(i ,j)位置放是否合適
              for (char k = '1'; k <= '9'; k++) {
                  if (isValid(i, j, k, board)) {
                      board[i][j] = k;
                      if (solveHelper(board)) {
                          return true;
                      }
                      board[i][j] = '.';
                  }
              }
              return false;
          }
      }
      return true;
  }

  public boolean isValid(int row, int col, char val, char[][] board) {
      for (int i = 0; i < 9; i++) {
          if (board[row][i] == val) {
              return false;
          }
      }

      for (int j = 0; j < 9; j++) {
          if (board[j][col] == val) {
              return false;
          }
      }

      int startRow = (row / 3) * 3;
      int startCol = (col / 3) * 3;
      for (int i = startRow; i < startRow + 3; i++) {
          for (int j = startCol; j < startCol + 3; j++) {
              if (board[i][j] == val) {
                  return false;
              }
          }
      }
      return true;
  }
}

/**
 * 解數獨： 填充一個9x9的數獨，確保每一行、每一列和九個3x3子網格內不包含重複數字
 * 
 * 解題思路：回溯
 * 
 * solveHelper函數用於DFS和回溯：
 * 用兩個for循環遍歷每一個格子，如果遇到的不是空格('.')，則跳過
 * 然後檢查在(i, j)的位置放1-9是否合適，調用isValid方法
 * 如果填充有效，遞歸調用solveHelper嘗試解決數獨的下一個空格，如果基於當前的數字能夠解決，則返回true
 * 如果不能解決，則回溯清空當前格子，嘗試下一個數字，如果所有數字都嘗試後沒辦法解決，就返回false，繼續上一層的回溯
 * 
 * 驗證函數isValid：
 * 檢查當前行、當前列和3x3的小格子內是否存在相同的數字，任何一處不滿足則直接返回false
 * 
 * 補充：如果用代碼確定數獨中3x3子區域的起始位置？
 * 數獨的棋盤是一個9x9的網格，可以分成9個3x3的子區域，每個子區域的起始點可以是 (0,0), (0,3), (0,6), (3,0), (3,3), (3,6), (6,0), (6,3), (6,6)
 * 
 * 計算行和列：使用row/3和col/3將網格中的行和列分別劃分為三個部分（每個部分包含三個行和三個列），這樣無論row和col的值是多少，row/3和col/3的結果都會落在012三個數字中
 * 計算起始點：將row/3和col/3再分別乘以3，找到相應子區域的左上角的行和列的索引
 **/