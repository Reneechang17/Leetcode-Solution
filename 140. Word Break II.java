// Hard
// DP
// O(n^2k)
// https://leetcode.com/problems/word-break-ii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
      Set<String> set = new HashSet<>(wordDict);
      List<String> res = new ArrayList<>();
      boolean[] dp = new boolean[s.length() + 1];

      dp[0] = true;

      for (int i = 1; i <= s.length(); i++) {
          for (int j = 0; j < i; j++) {
              if (dp[j] && set.contains(s.substring(j, i))) {
                  dp[i] = true;
                  break;
              }
          }
      }
      if (dp[s.length()]) {
          backtracking (s, set, 0, "", res, dp);
      }
      return res;
  }

  private void backtracking(String s, Set<String> set, int start, String path, List<String> res, boolean[] dp) {
      if (start == s.length()) {
          res.add(path.trim());
          return;
      }
      for (int end = start + 1; end <= s.length(); end++) {
          if (dp[end] && set.contains(s.substring(start, end))) {
              backtracking(s, set, end, path + s.substring(start, end) + " ", res, dp);
          }
      }
  }
}

/**
 * 單詞拆分2：給定一個非空字符串s和一個非空列表wordDict，用空格將s分割成一個或多個在字典中的單詞，返回所有可能的句子
 * 
 * 這裡有一個關鍵字就是找回所有可能的方案，那就要聯想到回溯
 * 首先可以用dp確定s的每個子字符串是否可以被wordDict中的單詞所組成（一樣是用外背包內物品），這步算是優化回溯，減少不必要的遞歸
 * 然後用回溯算法找所有可能的句子，從字符串的開始位置出發，尋找所有可以使用字典中單詞來結束的位置，然後遞歸處理
 **/