// Hard
// Brute Force..?, DP
// Time:O(m^2*n), Space:O(mn)
// https://leetcode.cn/problems/PLYXKQ/

class Solution {
    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;

        int n = matrix[0].length();
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '0') {
                    continue;
                }
                int width = left[i][j], area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
