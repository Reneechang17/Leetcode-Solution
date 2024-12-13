// Easy
// Two Pointers
// Time: O(n+m), Space: O(1)
// https://leetcode.cn/problems/merge-strings-alternately/

class Solution {
  // Use two pointers, and one get char from word1, then get another char from word2
  // And deal with the situation that word1 or word2 has remain char
  public String mergeAlternately(String word1, String word2) {
      StringBuilder sb = new StringBuilder();
      int i = 0, j = 0;
      while (i < word1.length() && j < word2.length()) {
          sb.append(word1.charAt(i++));
          sb.append(word2.charAt(j++));
      }
      while (i < word1.length()) sb.append(word1.charAt(i++));
      while (j < word2.length()) sb.append(word2.charAt(j++));
      return sb.toString();
  }
}
