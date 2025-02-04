// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/reverse-string/

class Solution {
  // Two Pointers to solve it
  public void reverseString(char[] s) {
      int left = 0, right = s.length - 1;
      while (left < right) {
          char temp = s[left];
          s[left] = s[right];
          s[right] = temp;
          left++;
          right--;
      }  
  }
}
