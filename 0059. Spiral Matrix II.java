// Medium
// Matrix
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/spiral-matrix-ii/

class Solution {
    // Simulate n*n matrix: right -> down -> left -> up
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (num <= n * n) {
            // left to right(on top)
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            // up to down(on right side)
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            // right to left(on bottom)
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            // down to up(on left)
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
