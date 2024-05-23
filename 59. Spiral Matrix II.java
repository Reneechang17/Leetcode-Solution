// Medium
// Array, Matrix
// O(n^2)

class Solution {
  public int[][] generateMatrix(int n) {
      int[][] ans = new int[n][n];
      int cnt = 1;
      int x1 = 0, x2 = n, y1 = 0, y2 = n;

      while(cnt <= n * n){
          for(int i = y1; i < y2; i++){
              ans[x1][i] = cnt++;
          }
          x1++;

          for(int i = x1; i < x2; i++){
              ans[i][y2 - 1] = cnt++;
          }
          y2--;

          for(int i = y2 - 1; i >= y1; i--){
              ans[x2 - 1][i] = cnt++;
          }
          x2--;

          for(int i = x2 - 1; i >= x1; i--){
              ans[i][y1] = cnt++;
          }
          y1++;
      }
      return ans;
  }
}