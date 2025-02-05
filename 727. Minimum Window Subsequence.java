// Hard
// dp, Sliding Window
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/minimum-window-subsequence/

class Solution {
    // dp[i][j]:start index of min window for s1[0...i-1] and s2[0...j-1]
    // If s1[i-1] == s2[j-1], dp[i][j] = dp[i-1][j-1]; else dp[i][j] = dp[i-1][j]
    public String minWindow(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // 定义dp数组：s1的前i个字符包含s2的前j个字符时的最短字串的起始位置
        // 不需要初始化dp数组，因为dp[i][j]的值在状态转移的过程中会被填充
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 如果j==1，说明当前字符是s2的第一个字符，直接记录当前索引i作为起始位置
                    // j=1 && s1[i-1]=s2[j]=>dp[i][j]=i
                    // 如果j>1，则继承dp[i-1][j-1]的值，表示当前字符匹配，继续匹配前面的字符
                    // j>1 && s1[i-1]=s2[j-1]=>dp[i][j]=dp[i-1][j-1]
                    dp[i][j] = j == 1 ? i : dp[i - 1][j - 1];
                } else {
                    // 继承dp[i-1][j]的值，表示当前字符不匹配，跳过s1的当前字符
                    // s1[i-1]!=s2[j-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // 找到最小的窗口
        int pos = 0, len = m + 1;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s2.charAt(n - 1) && dp[i][n] > 0) {
                int j = dp[i][n] - 1;
                if (i - j < len) {
                    len = i - j;
                    pos = j;
                }
            }
        }
        return len > m ? "" : s1.substring(pos, pos + len);
    }
}
