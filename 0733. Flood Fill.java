// Easy
// DFS
// Time:O(n*m), Space:O(n*m)
// https://leetcode.cn/problems/flood-fill/

class Solution {
  // DFS...? 
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int original = image[sr][sc];
      if (original != color) {
          dfs(image, sr, sc, original, color);
      }
      return image;
  }
  private void dfs(int[][] image, int r, int c, int original, int color) {
      // check boundaries
      if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != original) {
          return;
      }
      image[r][c] = color;
      dfs(image, r + 1, c, original, color);
      dfs(image, r - 1, c, original, color);
      dfs(image, r, c + 1, original, color);
      dfs(image, r, c - 1, original, color);
  }
}
