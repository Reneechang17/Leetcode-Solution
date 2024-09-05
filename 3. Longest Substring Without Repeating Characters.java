// Medium
// Sliding Window, Hash Table
// O(n)
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> map = new HashMap<>();
      int res = 0;
      int start = 0;

      for (int end = 0; end < s.length(); end++) {
          char cur = s.charAt(end);
          if (map.containsKey(cur)) {
              start = Math.max(start, map.get(cur) + 1);
          }
          map.put(cur, end);
          res = Math.max(res, end - start + 1);
      }
      return res;
  }
}

/**
 * 無重複字符的最長子串：給定一個字符串s，找到最長的子串的長度，該子串中沒有重複字符
 * 
 * 思路：滑動窗口（也可以看作是兩個指針），用哈希表來記錄字符出現的位置，當遇到重複字符時，將左指針移動到重複字符的下一個位置
 * 並更新最長子串的長度
 **/