// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/valid-palindrome/

class Solution {
  // use two pointers to compare
  // before comparing, we need to check if the left or right pointer is point to the valid char
  public boolean isPalindrome(String s) {
      int left = 0, right = s.length() - 1;

      while (left < right) {
          // skip the non-char pointers
          while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
              left++;
          }

          while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
              right--;
          }

          // compare the char of left and right pointers
          if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
              return false;
          }
          left++;
          right--;
      }
      return true;
  }
}
