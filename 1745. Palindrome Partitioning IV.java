// Hard
// DP
// Time:O(n^2),Space:O(n^2)
// https://leetcode.cn/problems/palindrome-partitioning-iv/

class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        // dp[i][j] represent if s[i..j] is palindrome
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j]  = true;
                } else if (j == i + 1) {
                    // when the length is 2
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // for more longer s[i..j]
                    // 1. start and end are equal 
                    // 2. s[i+1..j-1] are palindrome
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }
        }
        // try to partition to three palindrome
        // [0..i-1][i..j-1][j..n-1]
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
