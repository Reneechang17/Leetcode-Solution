// Hard
// Array, Backtracking
// O(n!)
// https://leetcode.com/problems/n-queens-ii/

class Solution {
  private int count = 0;
  private boolean[] cols;
  private boolean[] diag1;
  private boolean[] diag2;

  public int totalNQueens(int n) {
      cols = new boolean[n];
      diag1 = new boolean[2 * n];
      diag2 = new boolean[2 * n];
      backtracking(0, n);
      return count;
  }

  private void backtracking(int row, int n) {
      if (row == n) {
          count++;
          return;
      }

      for (int col = 0; col < n; col++) {
          int id1 = row - col + n;
          int id2 = row + col;
          if (cols[col] || diag1[id1] || diag2[id2]) continue;

          // Mark the cols and diags are occupied
          cols[col] = diag1[id1] = diag2[id2] = true;
          backtracking(row + 1, n);
          // Unmark
          cols[col] = diag1[id1] = diag2[id2] = false;
      }
  }
}

/**
 * 和51題不同的是：這個問題只需要返回所有解決方案的數量，而不是具體的棋盤佈局
 * 
 * 要找所有可能的解決方案，可以想到DFS和回溯法，因為這題要找到所有的可能，所以用回溯法會更好一些
 * （如果只需要找到任何一個解or最優解，DFS會更有效）
 * 
 * 回顧如何避免皇后互相攻擊？
 * 可以用boolean類型的數組來標記和追蹤
 * 1. 同一列被佔用
 * 2. 45度對角線：對於每個位置的(i, j), 它是由i-j的值決定的，這個值的範圍從-(n-1)到n-1，為了方便使用數組，我們可以對這個值加上n-1讓它成為非負
 * 3. 135度對角線：由i+j決定，這個值的範圍從0～2n-2
 * 
 * 回溯函數：試圖在每一行都放置一個皇后（遍歷列），然後遞歸解決下一行
 * 在放置皇后之前，先檢查該列及兩個對角線是否已經被佔用，如果沒有被佔用，則放置皇后並且遞歸至下一行，然後撤銷回到上一個狀態
 **/