// Medium
// Matrix
// Time:O(m*n),Space:O(1)
// https://leetcode.cn/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // check if first row contain zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // check if first col contain zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // traverse from second row/col and set flag to set zero
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set all marked row/col
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

/**
 * Mark first row/col to record whether a row/col should be set to zero
 * Traverse matrix starting from second row/col:
 *  - If matrix[i][j] is zero, mark the corresponding row/col in first row/col
 * Set matrix values to zero based on first row/col marks.
 * Handle first row/col separately since they are used for marking:
 *  - If `firstRowZero` flag is true, set the entire first row to zero
 *  - If `firstColZero` flag is true, set the entire first col to zero
 */
