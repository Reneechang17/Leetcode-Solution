// Medium
// DP
// Time:O(n^2),Space:O(n)
// https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency/

import java.util.*;
class Solution {
  public int minimumSubstringsInPartition(String s) {
      int n = s.length();
      int[] dp = new int[n + 1];
      for (int i = 1; i <= n; i++) {
          dp[i] = Integer.MAX_VALUE;
      }
      for (int i = 1; i <= n; i++) {
          // calculate the freq of chars
          Map<Character, Integer> freq = new HashMap<>();
          for (int j = i - 1; j >= 0; j--) {
              char c = s.charAt(j);
              freq.put(c, freq.getOrDefault(c, 0) + 1);
              // check if the freq is same
              if (isSame(freq)) {
                  // if sub s[j..i-1] is balanced, update dp[i]
                  if (j == 0) {
                      dp[i] = 1; // the whole sub is balanced
                  } else if (dp[j] != Integer.MAX_VALUE) {
                      dp[i] = Math.min(dp[i], dp[j] + 1);
                  }
              }
          }
      }
      return dp[n];
  }
  private boolean isSame(Map<Character, Integer> freq) {
      if (freq.isEmpty()) return false;
      int count = -1;
      for (int val : freq.values()) {
          if (count == -1) {
              count = val;
          } else if (val != count) {
              return false;
          }
      }
      return true;
  }
}

// 动态规划的核心思想是通过遍历所有可能的分割点 j，找到使 dp[i] 最小的分割方式
// 检查频率是否相等则是通过哈希表实现
// 从后往前遍历j计算s[j..i-1]的频率，可以避免重复计算，每次只需要增量s[j]的频率
// 不用每次重新计算整个子串频率
