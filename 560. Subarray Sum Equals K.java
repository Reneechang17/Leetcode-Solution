// Medium
// Prefix, HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/subarray-sum-equals-k/

import java.util.*;

class Solution {
  // The arr contains negative number so we cannot use Sliding Window
  // Use PrefixSum, and use HashMap to store each PrefixSum and its appear time
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(); // (prefixsum, appear time)
    map.put(0, 1); // select nothing
    int curSum = 0, res = 0;
    for (int num : nums) {
      curSum += num;
      // for each prefixsum, check if there have a prev prefixsum
      // such that their diff is k, if found, add to res
      res += map.getOrDefault(curSum - k, 0);
      map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    }
    return res;
  }
}

// 这题要注意约束条件：数组中包含负数，所以不能用滑窗，只看example可能会被误导
