// Hard
// DP
// Time:O(m*n), Space:O(m*n)
// https://leetcode.cn/problems/regular-expression-matching/

class Solution {
    // dp:表示s的前i个字符是否可以匹配p的前j个字符
    // 如果当前字符匹配或是'.':dp[i][j] = dp[i - 1][j - 1]
    // 如果当前是'*': 1.前一个元素出现0次, 则dp[i][j] = dp[i][j - 2]
    // 2. 如果当前字符于'*'之前的字符匹配(或是*之前的字符是.), 则dp[i][j] = dp[i - 1][j]
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // initialize: dp[0][0] = true, 空字符串可以匹配空正則表達式
        dp[0][0] = true;
        // 空字符串与模式匹配, 因为*可以表示0次重复
        // ex. 模式 p = "a*b*c*" 可以与空字符串匹配。
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
