// Medium
// String
// O(n)
// https://leetcode.com/problems/zigzag-conversion/

class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < rows.length; i++)
      rows[i] = new StringBuilder();

    int curRow = 0;
    boolean goingdown = false;

    for (char c : s.toCharArray()) {
      rows[curRow].append(c);
      if (curRow == 0 || curRow == numRows - 1)
        goingdown = !goingdown;
      curRow += goingdown ? 1 : -1;
    }
    StringBuilder res = new StringBuilder();
    for (StringBuilder row : rows)
      res.append(row);
    return res.toString();
  }
}

/**
 * 這題要求將字符串按照z字形排列，按行讀取並合併成新的字符串
 * 
 * 思路：
 * 創建一個和行數相等的StringBuilder來存儲每行的字符
 * 使用curRow來控制當前字符應該放在哪一行，另一個變量goingdown控制移動方向（上or下）
 * 遍歷字符串中的每一個字符，將其加入對應行的SB
 * 如果達到z字形的頂部或是底部則改變方向
 **/