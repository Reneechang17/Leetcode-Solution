// Medium
// Prefix, HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/subarray-sum-equals-k/

import java.util.*;
class Solution {
  // Since the arr contains negative number, we cannot use Sliding Window
  // Use PrefixSum, and use HashMap to store each PrefixSum and its appear time
  public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1); // select nothing
      int curSum = 0, res = 0;
      for (int num : nums) {
          curSum += num;
          // For each prefixsum, check if there a prev prefixsum 
          // such that their difference equals k
          res += map.getOrDefault(curSum - k, 0);
          map.put(curSum, map.getOrDefault(curSum, 0) + 1);
      }
      return res;
  }
}
