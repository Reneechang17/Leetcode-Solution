// Easy
// Math, String
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/excel-sheet-column-number/

class Solution {
  public int titleToNumber(String columnTitle) {
      int res = 0;
      for (int i = 0; i < columnTitle.length(); i++) {
          int curVal = columnTitle.charAt(i) - 'A' + 1;
          res = res * 26 + curVal;
      }
      return res;
  }
}
