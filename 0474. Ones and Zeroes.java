// Medium
// DP, String
// O(L * m * n)
// https://leetcode.com/problems/ones-and-zeroes/

class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
      int[][] dp = new int[m + 1][n + 1];
      
      int oneNum, zeroNum;
      for (String str : strs) {
          oneNum = 0;
          zeroNum = 0;
          for (char ch : str.toCharArray()) {
              if (ch == '0') {
                  zeroNum++;
              } else {
                  oneNum++;
              }
          }
          for (int i = m; i >= zeroNum; i--) {
              for (int j = n; j>= oneNum; j--) {
                  dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 給定一組由0和1組成的字符串數組strs和兩個整數m和n，找最多可以從數組中挑選多少字符串，使得這些字符串0的數量不超過m且1的數量不超過n
 * 
 * 本質上是在滿足一定條件之下去最大化挑選字符串的數量，可以每個字符串看成一個物品，每種物品有兩個成本，也就是有兩個背包（分別是容量為m和n的背包）
 * 任務是在不超過背包容量的情況下最大化挑選物品數
 * 所以dp數組表示的是 最多使用i個0和j個1的情況下，能夠挑選的字符串的最大數量
 **/