// Medium
// String, Stack
// O(N)
// https://leetcode.com/problems/removing-stars-from-a-string/

class Solution {
  public String removeStars(String s) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0 ; i < s.length(); i++) {
          if (s.charAt(i) == '*') {
              sb.deleteCharAt(sb.length() - 1);
          } else {
              sb.append(s.charAt(i));
          }
      }
      return sb.toString();
  }
}

/**
 * 可以用StringBuilder來模擬棧
 * 遍歷整個字符串，如果當前是*的話，就把棧頂彈出（deleteChat sb.length - 1)
 * 如果不是*，就直接入棧，最後再把sb.toString返回
 **/