// Medium
// Stack, Counting
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/

class Solution {
  // 这题的意思是找：缺少多少括号才能让整个字符串有效
  // 可以用计数
  public int minAddToMakeValid(String s) {
      int left = 0, right = 0;
      for (char c : s.toCharArray()) {
          if (c == '(') {
              left++;
          } else {
              if (left > 0) {
                  left--;
              } else {
                  right++;
              }
          }
      }
      return left + right;
  }
}
