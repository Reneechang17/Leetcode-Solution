// Medium
// Divide and Conquer
// Time:O(m+n), Space:O(1)
// https://leetcode.cn/problems/search-a-2d-matrix-ii/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // from top-right
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++; // search downside(search bigger)
            } else {
                col--; // search left side(search smaller)
            }
        }
        return false;
    }
}
