// Easy
// Matrix, Iteration
// Time:O(m*n), Space:O(1)
// https://leetcode.cn/problems/toeplitz-matrix/

class Solution {
    // Compare each element's val with its top-left element's val
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // skip first row and first col since they dont have top-left element
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
