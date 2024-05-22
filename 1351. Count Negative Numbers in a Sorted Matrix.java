// Easy
// Array, Binary Search
// O(m + n)

class Solution {
  public int countNegatives(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // count the negative number
    int ans = 0;

    // i is for rows, starting from the last row
    // j is for cols, starting from the first col
    for (int i = m - 1, j = 0; i >= 0 && j < n;) {
      // if the current element is negative
      if (grid[i][j] < 0) {
        // all elements from this point to the end of the row are negative
        // bcz the rows are sorted in non-decreasing order
        // add all these elements to the answer
        ans += n - j;
        // move up to the previous row
        --i;
      } else {
        // if the current element is non-negative, move to the next column
        ++j;
      }
    }
    return ans;
  }
}
