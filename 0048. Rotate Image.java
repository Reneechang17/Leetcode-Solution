// Medium
// Matrix
// O(n^2)
// https://leetcode.cn/problems/rotate-image/

class Solution {
    // we can find that we can swap the [i][j] -> [j][i]
    // and reverse the left and right
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
            // j can divide with 2, since we reverse the half can complete
            for (int j = 0; j <= n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j];
                matrix[i][n - j] = tmp;
            }
        }
    }
}
