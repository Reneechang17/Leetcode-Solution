// Hard
// Backtracking
// O(4^m * n)
// https://leetcode.com/problems/unique-paths-iii/

class Solution {
  int res = 0;
  int empty = 1; // 紀錄需要經過的空格數量
  int startX, startY, endX, endY;

  public int uniquePathsIII(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // 計算空格數量
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0)
          empty++;
        else if (grid[i][j] == 1) {
          startX = i;
          startY = j;
        } // 起點
        else if (grid[i][j] == 2) {
          endX = i;
          endY = j;
        } // 終點
      }
    }
    backtracking(grid, startX, startY);
    return res;
  }

  private void backtracking(int[][] grid, int x, int y) {
    // 檢查是否到達終點並且已經訪問所有空格
    if (x == endX && y == endY && empty == 0) {
      res++;
      return;
    }

    grid[x][y] = -2; // 標記當前位置為已經訪問
    int[] dx = { 0, 0, 1, -1 }; // 代表在行（x方向）上移動
    int[] dy = { 1, -1, 0, 0 }; // 代表在列（y方向）上移動
    // 有四個可能的方向
    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i], newY = y + dy[i];

      // 確保新位置有效且不是障礙物
      if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] >= 0) {
        empty--;
        backtracking(grid, newX, newY);
        empty++;
      }
    }
    grid[x][y] = 0;
  }
}

/**
 * 不同路徑3: 要求在一個網格中找到所有可能的起點到終點的路徑，條件為路徑必須走過每一個非障礙物恰好一次
 * 
 * 思路：這題需要探索所有可能的路徑，而且這些路徑要滿足特定要求，也就是需要枚舉，那就不像Unique Paths1、2一樣，可以用DP來解
 * DP適合找最優解，並且可以將問題拆分為子問題，也就是有狀態轉移的過程，所以這題比較適合用回溯
 * 
 * 這題題目傳入的參數也沒有長度，要自己定義。並且在初始化時，需要先找到起點和終點的位置，以及計算網格中空白格子的數量
 * 
 * 回溯方法：從起點開始，用遞歸嘗試所有可能的移動方向（上下左右）
 * 對於每一步，標記當前位置已經訪問，然後遞歸嘗試下一步
 * 如果到達終點，並且訪問所有empty，res++
 * 
 * dx和dy分別代表在x和y方向上移動
 * 對於每對dx[i], dy[i]表示：
 * 1. (dx[0], dy[0]) = (0, 1)：表示從當前位置向右移動
 * 2. (dx[1], dy[1]) = (0, -1)：表示從當前位置向左移動
 * 3. (dx[2], dy[2]) = (1, 0)：表示從當前位置向下移動
 * 4. (dx[3], dy[3]) = (-1, 0)：表示從當前位置向上移動
 **/