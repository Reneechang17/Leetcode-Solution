// Medium
// DP
// O(n^2k)
// https://leetcode.com/problems/word-break/

import java.util.HashSet;
import java.util.List;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      HashSet<String> set = new HashSet<>(wordDict);
      boolean[] dp = new boolean[s.length() + 1];

      dp[0] = true; 

      for (int i = 1; i <= s.length(); i++) {
          for (int j = 0; j < i && !dp[i]; j++) {
              if (set.contains(s.substring(j, i)) && dp[j]) {
                  dp[i] = true;
              }
          }
      }
      return dp[s.length()];
  }
}

/**
 * 單詞拆分：判斷字符串s是否可以被分割成一個或多個在wordDict中出現的單詞
 * 
 * 這是一題背包問題，可以將單詞看作物品，字符串s看作背包，看單詞能不能組成s，就是問物品能不能把背包裝滿
 * dp數組表示字符串的前i個字符可不可以被拆分
 * 
 * dp[0]初始化為true，dp[i]由dp[j]推出來的，如果初始化不是true，後面全部都是false
 * 
 * 另外這題也是一個排列問題，ex. leetcode 需要用leet+code拼起來，code+leet不行
 * => 外背包、內物品
 **/