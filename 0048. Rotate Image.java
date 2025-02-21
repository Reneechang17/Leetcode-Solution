// Medium
// Matrix
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/rotate-image/

class Solution {
    // We can find -> swap element at [i][j] and [j][i]
    // Reverse each row after transposing to get 90-degree rotation
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i <= n; i++) {
            // j can divide with 2, since we can only reverse half to achieve
            for (int j = 0; j <= n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j];
                matrix[i][n - j] = tmp;
            }
        }
    }
}
