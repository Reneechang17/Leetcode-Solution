// Medium
// DFS
// O(n)
// https://leetcode.com/problems/max-area-of-island/

class Solution {
  public int maxAreaOfIsland(int[][] grid) {
      int maxArea = 0;
      int rows = grid.length;
      int cols = grid[0].length;

      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              if (grid[i][j] == 1) {
                  maxArea = Math.max(maxArea, dfs(grid, i, j));
              }
          }
      }
      return maxArea;
  }

  private int dfs(int[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
          return 0;
      }

      grid[i][j] = 0; // we vistied already
      int area = 1; 

      area += dfs(grid, i - 1, j);
      area += dfs(grid, i + 1, j);
      area += dfs(grid, i, j - 1);
      area += dfs(grid, i, j + 1);

      return area;
  }
}

/**
 * 島嶼的最大面積：在二維網格中，0代表水，1代表陸地，一個島嶼是由相鄰的1（水平或垂直）組成的，要求找最大的島嶼面積
 * 
 * 思路：這題可以用DFS、BFS和並查集做，這裡用DFS，因為比較直觀好懂
 * DFS是用遞歸遍歷所有相鄰的陸地1，然後計算它上下左右的面積，每次找到一個島嶼，就把它標記為已經訪問（這裡用0），避免重複計算
 * 
 * followup：如果要求找到最大的島嶼的左上角和右下角的坐標，可以在DFS的過程中紀錄每個島嶼的左上角和右下角的坐標
 * 如果用BFS的話就是用隊列來遍歷每個島嶼的相鄰節點
 * 而並查集則是將陸地看作一個獨立的集合，然後將相鄰的陸地合併到同一個集合中，最後找到最大的集合
 **/