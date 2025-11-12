// Easy
// Intervals
// O(n)
// https://leetcode.cn/problems/summary-ranges/

import java.util.*;

class Solution {
  public List<String> summaryRanges(int[] nums) {
      List<String> res = new ArrayList<>();
      // basecase
      if (nums.length == 0) return res;

      // set the cur range's start
      int start = nums[0];

      for (int i = 1; i < nums.length; i++) {
          // if not continue
          if (nums[i] != nums[i - 1] + 1) {
              // if start is equal to prev one
              // than add the single value, or add a range
              if (start == nums[i - 1]) {
                  res.add(String.valueOf(start));
              } else {
                  res.add(start + "->" + nums[i - 1]);
              }
              // update the start as current
              start = nums[i];
          }
      }

      // deal with last range
      if (start == nums[nums.length - 1]) {
          res.add(String.valueOf(start));
      } else {
          res.add(start + "->" + nums[nums.length - 1]);
      }
      return res;
  }
}
