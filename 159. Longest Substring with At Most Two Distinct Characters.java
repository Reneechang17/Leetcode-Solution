// Medium
// Two Pointers, Hash Table
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/

import java.util.*;
class Solution {
  // Use HashMap to count character frequencies in the window
  // Expand right pointer to include new characters
  // If there are more than two distinct chars, move left to shrink the window
  public int lengthOfLongestSubstringTwoDistinct(String s) {
      Map<Character, Integer> map = new HashMap<>();
      int left = 0, maxLen = 0;
      for (int right = 0; right < s.length(); right++) {
          char c = s.charAt(right);
          map.put(c, map.getOrDefault(c, 0) + 1);
          while (map.size() > 2) {
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
