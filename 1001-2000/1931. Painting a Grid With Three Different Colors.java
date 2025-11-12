// Hard
// DP
// Time:O(n × s²),Space:O(s)
// https://leetcode.cn/problems/painting-a-grid-with-three-different-colors/

import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<Integer> validCols = generateValidCols(m);
        int colSize = validCols.size();

        // 记录哪些列的状态可以相邻
        boolean[][] graph = new boolean[colSize][colSize];
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < colSize; j++) {
                graph[i][j] = isValid(validCols.get(i), validCols.get(j), m);
            }
        }

        // dp数组：dp[i]表示第i列的方案数
        long[] dp = new long[colSize];
        Arrays.fill(dp, 1);

        for (int col = 1; col < n; col++) {
            long[] newDp = new long[colSize];

            // 当前列的状态
            for (int j = 0; j < colSize; j++) {
                // 上一列的状态
                for (int i = 0; i < colSize; i++) {
                    if (graph[i][j]) {
                        newDp[j] = (newDp[j] + dp[i]) % MOD;
                    }
                }
            }
            dp = newDp;
        }
        
        long total = 0;
        for (long x : dp) {
            total = (total + x) % MOD;
        }

        return (int) total;
    }

    // 用三进制表示三种颜色
    private List<Integer> generateValidCols(int m) {
        List<Integer> res = new ArrayList<>();
        helper(0, 0, -1, m, res);
        return res;
    }

    private void helper(int state, int pos, int lastColor, int m, List<Integer> res) {
        if (pos == m) {
            res.add(state);
            return;
        }

        // 尝试三种颜色
        for (int c = 0; c < 3; c++) {
            if (c != lastColor) {
                helper(state * 3 + c, pos + 1, c, m, res);
            }
        }
    }

    // 检查两列是否兼容（相邻格子颜色不能相同）
    private boolean isValid(int col1, int col2, int m) {
        for (int i = 0; i < m; i++) {
            int c1 = col1 % 3, c2 = col2 % 3;
            if (c1 == c2) return false;

            col1 /= 3;
            col2 /= 3;
        }
        return true;
    }
}
