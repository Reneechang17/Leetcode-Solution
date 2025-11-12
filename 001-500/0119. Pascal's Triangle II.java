// Easy
// Array
// Time:O(rowIndex^2), Space:O(rowIndex)
// https://leetcode.cn/problems/pascals-triangle-ii/

import java.util.*;

class Solution {
  // Start with the first row, which is [1]
  // Iteratively update each row from prev one by adding values from prev row
  public List<Integer> getRow(int rowIndex) {
      List<Integer> res = new ArrayList<>();
      res.add(1);
      for (int i = 1; i <= rowIndex; i++) {
          // from right to left
          for (int j = i - 1; j > 0; j--) {
              // ser() use to replace a as b
              res.set(j, res.get(j) + res.get(j - 1));
          }
          res.add(1); // last element is 1
      }
      return res;
  }
}
