// Hard
// DP
// Time:O(n^4), Space:O(n^3)
// https://leetcode.cn/problems/scramble-string/

class Solution {
  public boolean isScramble(String s1, String s2) {
      if (s1.length() != s2.length()) return false;
      if (s1.equals(s2)) return true;

      int n = s1.length();
      // dp[i][j][len] means if s1[i,i+len] is scramble of s2[j,j+len]
      boolean[][][] dp = new boolean[n][n][n + 1];

      // basecase: single chars
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
          }
      }

      // DP: length from 2 to n
      for (int len = 2; len <= n; len++) {
          for (int i = 0; i <= n - len; i++) {
              for (int j = 0; j <= n - len; j++) {
                  for (int k = 1; k < len; k++) {
                      // check two cases: swap or no swap
                      dp[i][j][len] = dp[i][j][k] && dp[i + k][j + k][len - k] ||
                      dp[i][j + len - k][k] && dp[i + k][j][len - k];
                      if (dp[i][j][len]) break; // if found a valid scramble
                  }
              }
          }
      }
      return dp[0][0][n];
  }
}

// 给定两个字符串s1和s2，判断s2是不是s1的scramble字符串，可以通过以下方式不断拆分和交换s1得到s2：
// 1. 将s1分成2部分，交换这两部分，递归将这两部分分别做scramble
// 2. 如果没有交换，只是递归将两部分分别做scramble
// 递归思路：假设s1和s2具有相同长度，并且字符频率相同。
//   - 将s1分成2个子串，递归判断两个子串是否可以通过交换或不交换得到s2
// DP：考虑到字符串长度和拆分方式，可以定义一个三维数组：
//   - dp[i][j][len]表示s1[i:i+len]和s2[j:j+len]是否是scramble字符串

