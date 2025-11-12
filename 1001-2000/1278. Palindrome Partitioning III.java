// Hard
// DP, Two Pointers
// Time:O(n^2*k),Space:O(n*k)
// https://leetcode.cn/problems/palindrome-partitioning-iii/

class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            // j最多是i，因为不能有更多回文子串
            for (int j = 1; j <= Math.min(k, i); j++) {
                if (j == 1) {
                    // 只有一个回文子串则计算s[0..i-1]变成回文的最小cost
                    dp[i][j] = cost(0, i - 1, s);
                } else {
                    for (int p = j - 1; p < i; p++) {
                        // 尝试所有分割点p，将前p个字符分割成j-1个回文子串
                        // cost(p, i-1, s)表示将子串s[p..i-1]变成回文的最小cost
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + cost(p, i - 1, s));
                    }
                }
            }
        }
        return dp[n][k];
    }
    // 计算将s[left..right]转换成回文的最小代价
    // 双指针check两端元素是否相同，不同则cost+1
    private int cost(int left, int right, String s) {
        int cost = 0;
        while (left < right) {
            cost += (s.charAt(left) == s.charAt(right) ? 0 : 1);
            left++;
            right--;
        }
        return cost;
    }
}
