// Medium
// DP
// Time:O(m*n^2), Space:O(m*n)
// https://leetcode.cn/problems/count-submatrices-with-all-ones/
// TODO: tag says it can be optimized the space and use stack

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[][] heights = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[i][j] = (i == 0) ? 1 : heights[i - 1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;

                int min = Integer.MAX_VALUE;

                for (int k = j; k >= 0; k--) {
                    min = Math.min(min, heights[i][k]);
                    if (min == 0) break; // min = 0, can't expand left forward

                    res += min;
                }
            }
        }
        return res;
    }
}
