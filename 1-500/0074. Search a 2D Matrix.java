// Medium
// Binary Search
// Time:O(log(m * n)), Space:O(1)
// https://leetcode.cn/problems/search-a-2d-matrix/

class Solution {
  // We can treat the matrix as a flattened sorted array
  // Use binary search to locate the target, since the solution should be O(log(m * n))
  // Convert the mid index in the "1D array" back to row and col in the matrix
  public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length, n = matrix[0].length;
      int left = 0, right = m * n - 1;
      while (left <= right) {
          int mid = (left + right) >> 1;
          // map 1D index to 2D row and col
          int midValue = matrix[mid / n][mid % n];
          if (midValue == target) {
              return true;
          } else if (midValue < target) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return false;
  }
}
