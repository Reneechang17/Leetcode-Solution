// Easy
// Array
// Time:O(n), Space:O(k)
// https://leetcode.cn/problems/missing-ranges/

import java.util.*;

class Solution {
  // edgecase: if nums is null, range from lower to upper is answer
  // The final range will from lower to nums[0] & range between nums
  //  and from nums[nums.length - 1] to upper
  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
      List<List<Integer>> res = new ArrayList<>();

      if (nums == null || nums.length == 0) {
          addRange(res, lower, upper);
          return res;
      }

      // add range between lower and nums[0]
      addRange(res, lower, nums.length > 0 ? nums[0] - 1 : upper);

      // add range between nums
      for (int i = 1; i < nums.length; i++) {
          addRange(res, nums[i - 1] + 1, nums[i] - 1);
      }

      // add range between nums[nums.length - 1] and upper
      addRange(res, nums.length > 0 ? nums[nums.length - 1] + 1 : lower, upper);

      return res;
  }
  private void addRange(List<List<Integer>> res, int start, int end) {
      if (start > end) return;
      List<Integer> range = new ArrayList<>();
      if (start == end) {
          range.add(start);
          range.add(end);
      } else {
          range.add(start);
          range.add(end);
      }
      res.add(range);
  }
}
