// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-distance-in-arrays/

import java.util.*;
class Solution {
  // minValue: nums[i][0], maxValue: nums[i][last] -> sorted arr
  public int maxDistance(List<List<Integer>> arrays) {
      int minVal = arrays.get(0).get(0);
      int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
      int maxDiff = 0;

      for (int i = 1; i < arrays.size(); i++) {
          List<Integer> arr = arrays.get(i);
          int first = arr.get(0), last = arr.get(arr.size() - 1);
          maxDiff = Math.max(maxDiff, Math.max(Math.abs(last - minVal), Math.abs(first - maxVal)));
          minVal = Math.min(minVal, first);
          maxVal = Math.max(maxVal, last);
      }
      return maxDiff;
  }
}
