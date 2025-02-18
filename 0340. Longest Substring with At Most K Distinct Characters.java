// Medium
// Two Pointers, Hash Table
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/

import java.util.*;
class Solution {
  // Use HashMap to track character frequency in the window
  // Expand right pointer to add new characters
  // If the number of distinct characters exceeds K, shrink window
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (k == 0) return 0;
      Map<Character, Integer> map = new HashMap<>();
      int left = 0, maxLen = 0;
      for (int right = 0; right < s.length(); right++) {
          char c = s.charAt(right);
          map.put(c, map.getOrDefault(c, 0) + 1);
          while (map.size() > k) {
              char leftChar = s.charAt(left);
              map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
              if (map.get(leftChar) == 0) {
                  map.remove(leftChar);
              }
              left++;
          }
          maxLen = Math.max(maxLen, right - left + 1);
      }
      return maxLen;
  }
}
