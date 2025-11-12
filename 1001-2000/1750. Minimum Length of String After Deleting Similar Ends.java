// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/

class Solution {
  public int minimumLength(String s) {
      int left = 0, right = s.length() - 1;
      while (left < right && s.charAt(left) == s.charAt(right)) {
          char cur = s.charAt(left);
          while (left <= right && s.charAt(left) == cur) left++;
          while (left <= right && s.charAt(right) == cur) right--;
      }
      return right - left + 1;
  }
}
