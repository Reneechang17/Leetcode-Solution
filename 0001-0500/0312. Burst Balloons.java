// Hard
// DP
// Time:O(n^3),Space:O(n^2)
// https://leetcode.cn/problems/burst-balloons/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 因為邊界數字還要乘以1，可以給dp數組加入虛擬氣球方便計算
        int[] numsAddBoundary = new int[n + 2];
        for (int i = 0; i < n; i++) {
            numsAddBoundary[i + 1] = nums[i];
        }
        numsAddBoundary[0] = 1;
        numsAddBoundary[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n + 2; len++) { // length of range from i to j
            // i and j are starting and ending point
            for (int i = 0; i <= n + 1 - len; i++) {
                int j = i + len;
                // try to burst every balloon between i and j, and take best choice
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + numsAddBoundary[i] * numsAddBoundary[k] * numsAddBoundary[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}

/**
 * 這題可以用DP解，無法用貪心，因為每次都選最大不能最後得到最大。
 * dp[i][j]表示從第i個氣球到第j個氣球之間，最優戳破順序可以獲得的最大硬幣數量
 * 當選擇一個氣球k戳破時，得分為dp[i-1]*dp[k]*dp[j+1]，加上戳破i～j範圍內所有氣球的最大分數，
 * 即dp[i][k]+dp[k][j]
 */
