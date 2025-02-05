// Medium
// DP
// Time:O(n^2),Space:O(n)
// https://leetcode.cn/problems/partition-string-into-minimum-beautiful-substrings/

import java.util.*;
class Solution {
  public int minimumBeautifulSubstrings(String s) {
      int n = s.length();
      // precompute all binary representations of powers of 5
      Set<String> powerOfFive = new HashSet<>();
      int num = 1;
      while (true) {
          String binary = Integer.toBinaryString(num);
          if (binary.length() > n) break;
          powerOfFive.add(binary);
          num *= 5;
      }
      // DP: min num of beautifal substring for s[0...i-1]
      int[] dp = new int[n + 1];
      for (int i = 1; i <= n; i++) {
          dp[i] = Integer.MAX_VALUE; // initialize to infinity
      }
      for (int i = 1; i <= n; i++) {
          for (int j = 0; j < i; j++) {
              String sub = s.substring(j, i);
              // check if sub is a power of 5 and has no leading zero
              // if satisfy, we can split s[0..i-1] into 2 parts:
              //  - s[0..j-1]: the split times is dp[j]
              //  - s[j..i-1]: a beautiful sub, split time +1
              if (powerOfFive.contains(sub) && (j == 0 || dp[j] != Integer.MAX_VALUE)) {
                  dp[i] = Math.min(dp[i], dp[j] + 1);
              }
          }
      }
      return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
  }
}

// 这题动态规划的核心是找到分割点 j，将字符串分成两部分：
//  前一部分s[0..j-1]的分割次数是dp[j]
//  后一部分s[j..i-1]是一个美丽子串
// 通过遍历所有可能的j，找到使dp[i]最小的分割点，从而得到最少的分割次数
