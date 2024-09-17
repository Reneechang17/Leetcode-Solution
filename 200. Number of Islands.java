// Medium
// Graph, DFS
// O(m * n)
// https://leetcode.com/problems/number-of-islands/

class Solution {
  public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
          return 0;
      }
      int island_num = 0;
      int rows = grid.length;
      int cols = grid[0].length;

      for (int i = 0; i < rows; i++) {
          for (int j  = 0; j < cols; j++) {
              if (grid[i][j] == '1') {
                  island_num++;
                  dfs(grid, i, j);
              }
          }
      }
      return island_num;
  }
  private void dfs (char[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
          return;
      }
      grid[i][j] = '0'; // 標記為0，表示已訪問

      dfs(grid, i - 1, j); // 上
      dfs(grid, i + 1, j); // 下
      dfs(grid, i, j - 1); // 左
      dfs(grid, i, j + 1); // 右
  }
}

/**
 * 島嶼個數：計算一個二維網格中有多少島嶼，島嶼由水平或是垂直的‘1’組成，而‘0’則是分隔開了島嶼
 * 
 * 這題可以看作一題圖遍歷，因為我們需要找到圖中連通的分量（即島嶼）
 * 可以用DFS或者BFS來解決，這裡用DFS來解決：從某個陸地開始，遞歸探索四個方向（上下左右），並標記屬於同一個島嶼的陸地
 **/