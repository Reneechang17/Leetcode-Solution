// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/valid-palindrome-ii/

class Solution {
  public boolean validPalindrome(String s) {
      int left = 0, right = s.length() - 1;
      while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
              // try skip either left or right char and check if valid
              return isValid(s, left + 1, right) || isValid(s, left, right - 1);
          }
          left++;
          right--;
      }
      return true;
  }
  private boolean isValid(String s, int left, int right) {
      while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
              return false;
          }
          left++;
          right--;
      }
      return true;
  }
}
