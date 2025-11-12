// Hard
// DP, LPS
// Time:O(n^2), Space:O(n^2)
// https://leetcode.cn/problems/valid-palindrome-iii/

class Solution {
    // 原字符串长度-最长回文子序列长度<=k -> true
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // 单个字符是回文
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1] <= k;
    }
}
