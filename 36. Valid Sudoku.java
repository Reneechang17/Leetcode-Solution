// Medium
// Hash Table
// O(1)
// https://leetcode.com/problems/valid-sudoku/

import java.util.HashSet;

class Solution {
  public boolean isValidSudoku(char[][] board) {
      HashSet<String> set = new HashSet<>();

      for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
              char num = board[i][j];
              if (num != '.') {
                  String row = num + "in row" + i;
                  String col = num + "in col" + j;
                  String block = num + "in block" + (i / 3) + "-" + (j / 3);

                  if (!set.add(row) || !set.add(col) || !set.add(block)) {
                      return false;
                  }
              }
          }
      }
      return true;
  }
}

/**
 * 驗證數獨是否有效
 * 
 * 核心思路：利用HashSet來存儲和檢查已經遇到的數字和其位置信息，以確保每個數字在其所在行、列以及3x3九宮格內只出現一次，以避免重複
 * 逐一遍歷數獨，如果格子為空('.')，則不需要做任何操作，繼續下一個格子；如果格子內有數字，則進行檢查
 * 對於每個數字，可以構造三個字符串來標識其在當前數獨中的位置（因為我們的set存儲字符串）
 * 對於每個字符串，嘗試將其添加到set，如果添加成功，代表這個數字在當前位置是首次出現，則繼續檢查下一個格子；如果添加失敗，表示該數字在當前的行列or宮格出現過，返回false
 **/