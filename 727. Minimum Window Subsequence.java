// Hard
// dp, Sliding Window
// O(m + n) the length of s1 & s2

class Solution {
  public String minWindow(String s1, String s2) {
      int m = s1.length(), n = s2.length();
      int[][] dp = new int[m + 1][n + 1];
      // 定義dp數組：s1的前i個字符包含s2的前j個字符時的最短子串的起始位置
      for(int i = 1; i <= m; i++){
          for(int j = 1; j <= n; j++){
              if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                  // 當j = 1 && s1[i - 1] = s2[j] => dp[i][j] = i
                  // 當j > 1 && s1[i - 1] = s2[j - 1] => dp[i][j] = dp[i - 1][j - 1]
                  dp[i][j] = j == 1 ? i : dp[i - 1][j - 1];
              } else{
                  // 當s1[i - 1] != s2[j - 1]
                  dp[i][j] = dp[i - 1][j];
              }
          }
      }
      // 遍歷s1，如果dp[i][n] > 0 ,更新最短子串的起始位置 & 長度
      int pos = 0, len = m + 1;
      for(int i = 1; i <= m; i++){
          if(s1.charAt(i - 1) == s2.charAt(n - 1) && dp[i][n] > 0){
              int j = dp[i][n] - 1;
              if(i - j < len){
                  len = i - j;
                  pos = j;
              }
          }
      }
      return len > m ? "" : s1. substring(pos, pos + len);
  }
}
