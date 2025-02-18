// Easy
// Simulation?
// Time:O(numRows^2), Space:O(numRows^2)
// https://leetcode.cn/problems/pascals-triangle/

import java.util.*;

class Solution {
  // For each row:
  //  - the first and last elements are always 1
  //  - middle elements are the sum of two element from prev row
  // Generate each row based on the above rules and add it to the res
  public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
          List<Integer> row = new ArrayList<>();
          for (int j = 0; j <= i; j++) {
              if (j == 0 || j == i) {
                  row.add(1);
              } else {
                  row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
              }
          }
          res.add(row);
      }
      return res;
  }
}
