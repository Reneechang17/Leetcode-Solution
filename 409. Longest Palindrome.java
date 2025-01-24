// Easy
// Count
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-palindrome/

class Solution {
  public int longestPalindrome(String s) {
      int[] count = new int[52];
      for (char c : s.toCharArray()) {
          if (c >= 'A' && c <= 'Z') {
              count[c - 'A']++;
          } else if (c >= 'a' && c <= 'z') {
              count[c - 'a' + 26]++;
          }
      }
      int length = 0;
      for (int freq : count) {
          // add even part of freq
          length += freq / 2 * 2;
          // add one odd char as center if applicable
          if (length % 2 == 0 && freq % 2 == 1) {
              length++;
          }
      }
      return length;
  }
}
