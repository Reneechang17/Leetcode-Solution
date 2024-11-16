// Medium
// Prefix, Hash Table
// O(n)
// https://leetcode.cn/problems/subarray-sum-equals-k/

import java.util.*;

class Solution {
  // find all the subarrays which sum is equal to k
  // we can use prefixsum and hashmap, the map store the 
  // [prefixsum, and tims that prefixsum happened]
  public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      // only when we are not select any element
      // the prefix sum will be zero
      map.put(0, 1); 

      int curSum = 0, res = 0;
      for (int num : nums) {
          curSum += num; // update the prefix sum
          // check if map has curSum - k, if so add to res
          res += map.getOrDefault(curSum - k, 0);
          // update the map
          map.put(curSum, map.getOrDefault(curSum, 0) + 1);
      }
      return res;
  }
}
