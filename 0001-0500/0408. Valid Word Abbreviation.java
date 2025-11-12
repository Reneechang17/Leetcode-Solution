// Easy
// Two Pointers
// Time:O(n+m),Space:O(1)
// https://leetcode.cn/problems/valid-word-abbreviation/

class Solution {
  public boolean validWordAbbreviation(String word, String abbr) {
      int i = 0, j = 0;
      while (i < word.length() && j < abbr.length()) {
          if (Character.isLetter(abbr.charAt(j))) {
              // 直接匹配字母
              if (word.charAt(i) != abbr.charAt(j)) {
                  return false;
              }
              i++;
              j++;
          } else {
              // 處理數字跳過
              if (abbr.charAt(j) == '0') return false;
              int num = 0;
              while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                  num = num * 10 + (abbr.charAt(j) - '0');
                  j++;
              }
              i += num; // 在word裡跳過num個字符
          }
      }
      // 如果ij指針都走到最後則匹配成功
      return i == word.length() && j == abbr.length();
  }
}
