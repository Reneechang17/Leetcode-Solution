// Easy
// String
// O(n)
// https://leetcode.cn/problems/length-of-last-word/

class Solution {
  public int lengthOfLastWord(String s) {
      // clear the space after the last one
      s = s.trim();
      int len = 0;

      // iterate from last one, and if we occur the space, means we find the last word
      // then break it, or calculate the len
      for (int i = s.length() - 1; i >= 0; i--) {
          if (s.charAt(i) == ' ') {
              break;
          }
          len++;
      }
      return len;
  }
}
