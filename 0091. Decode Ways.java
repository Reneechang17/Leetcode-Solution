// Medium
// DP
// O(n)
// https://leetcode.cn/problems/decode-ways/

class Solution {
  public int numDecodings(String s) {
      if (s.length() == 0 || s == null) {
          return 0;
      }

      int n = s.length();
      // dp數組表示前i個字符的解碼方式個數
      int[] dp = new int[n + 1];

      dp[0] = 1; // 空字符串
      dp[1] = s.charAt(0) != '0' ? 1 : 0; // 第一個字符單獨處理，如果不是0，則只有一種解碼方式

      for (int i = 2; i <= n; i++) {
          char oneDigit = s.charAt(i - 1);
          char twoDigits = s.charAt(i - 2);

          // 如果當前字符不是0，則可以單獨解碼
          if (oneDigit != '0') {
              dp[i] += dp[i - 1];
          }

          // 如果當前兩位數在10～26之間，則可以作為一個兩位數做解碼
          if (twoDigits == '1' || (twoDigits == '2' && oneDigit <= '6')) {
              dp[i] += dp[i - 2];
          }
      }
      return dp[n];
  }
}

/**
 * 解碼方式：給定一個只包含數字的字符串，計算解碼方法的總數，每個數字字符串代表字母的編碼
 * 
 * 思路：DP，dp數組表示前i個字符的解碼方式個數
 * 如果當前的字符是0，則無法單獨解碼，只能和前一個字符組合解碼（只需要考慮前一個字符是否是1或2）
 * 如果當當前字符不是0，則可以單獨解碼 => dp[i] += dp[i - 1]
 * 如果當前兩位數在10～26之間，那麼當前字符可以和前一個字符組成一個兩位數進行解碼 => dp[i] += dp[i - 2]
 **/