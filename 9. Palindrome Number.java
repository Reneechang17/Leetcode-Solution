// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/palindrome-number/

class Solution {
  public boolean isPalindrome(int x) {
      // 首先負數不可能是回文數
      if (x < 0) {
          return false;
      }

      // 雙指針檢查
      String s = Integer.toString(x);
      int left = 0, right = s.length() - 1;
      
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
