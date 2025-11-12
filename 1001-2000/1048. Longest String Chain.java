// Medium
// Hash Table, DP
// O(n * m^2)
// https://leetcode.cn/problems/longest-string-chain/

import java.util.*;

class Solution {
  // 可以枚举检查因为这题数据量不大
  // 可以将问题看作是找到每个单词的最长链的长度：定义一个哈希表，表示以word为结尾的最长链的长度。
  public int longestStrChain(String[] words) {
      // 将单词按长度从短到长排序，确保当我们处理一个单词时，所有它的可能前身（长度少 1 的单词）已经被处理过
      Arrays.sort(words, (a, b) -> a.length() - b.length());
      int maxLength = 1;
      Map<String, Integer> dp = new HashMap<>(); // map存储每个单词以及其最长链长度

      for (String s : words) {
          int curLength = 1;

          // 枚举所有可能的前身，去掉 s[i]
          for (int i = 0; i < s.length(); i++) {
              String t = s.substring(0, i) + s.substring(i + 1);
              curLength = Math.max(curLength, dp.getOrDefault(t, 0) + 1);
          }

          dp.put(s, curLength);
          maxLength = Math.max(curLength, maxLength);
      }
      return maxLength;
  }
}
