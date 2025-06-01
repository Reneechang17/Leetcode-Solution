// Medium
// DP
// Time:O(mn), Space:O(n)
// https://leetcode.cn/problems/minimum-number-of-operations-to-satisfy-conditions/

class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] operations = new int[n][10]; // turn each col to 0-9

        for (int c = 0; c < n; c++) {
            for (int d = 0; d < 10; d++) {
                int opt = 0;
                for (int r = 0; r < m; r++) {
                    if (grid[r][c] != d) {
                        opt++;
                    }
                }
                operations[c][d] = opt;
            }
        }

        if (n == 1) {
            int minCost = Integer.MAX_VALUE;
            for (int d = 0; d < 10; d++) {
                minCost = Math.min(minCost, operations[0][d]);
            }
            return minCost;
        }

        int[][] dp = new int[n][10];
        for (int d = 0; d < 10; d++) {
            dp[0][d] = operations[0][d];
        }

        for (int c = 1; c < n; c++) {
            for (int curD = 0; curD < 10; curD++) {
                dp[c][curD] = Integer.MAX_VALUE;
                for (int prevD = 0; prevD < 10; prevD++) {
                    if (prevD != curD) {
                        dp[c][curD] = Math.min(dp[c][curD], dp[c - 1][prevD] + operations[c][curD]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int d = 0; d < 10; d++) {
            res = Math.min(res, dp[n - 1][d]);
        }
        return res;
    }
}
