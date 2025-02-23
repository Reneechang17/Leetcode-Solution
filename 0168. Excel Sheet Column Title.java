// Easy
// Math, String
// Time:O(logn),Space:O(logn)
// https://leetcode.cn/problems/excel-sheet-column-title/

class Solution {
  public String convertToTitle(int columnNumber) {
      StringBuilder sb = new StringBuilder();
      while (columnNumber > 0) {
          int a0 = (columnNumber - 1) % 26 + 1;
          sb.append((char)(a0 - 1 + 'A'));
          columnNumber = (columnNumber - a0) / 26;
      }
      return sb.reverse().toString();
  }
}
