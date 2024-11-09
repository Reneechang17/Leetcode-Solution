// Medium
// String
// O(n)
// https://leetcode.cn/problems/zigzag-conversion/

class Solution {
  public String convert(String s, int numRows) {
      // if only one row or the string length smaller than numRows
      if (numRows == 1 || s.length() <= numRows) {
          return s;
      }

      StringBuilder[] rows = new StringBuilder[numRows];
      for (int i = 0; i < numRows; i++) {
          rows[i] = new StringBuilder();
      }

      int curRow = 0; // the index of cur row
      boolean goingdown = false; // default direction is down

      for (char c : s.toCharArray()) {
          // append the char to the curRow
          rows[curRow].append(c);
          // if reach the top or bottom
          if (curRow == 0 || curRow == numRows - 1) {
              goingdown = !goingdown; // change the direction
          }
          curRow += goingdown ? 1 : -1;
      }

      StringBuilder res = new StringBuilder();
      for (StringBuilder row : rows) {
          res.append(row);
      }

      return res.toString();
  }
}
