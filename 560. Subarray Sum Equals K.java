// Medium
// Prefix, Hash Table
// O(n)
// Similar: 974
// https://leetcode.cn/problems/subarray-sum-equals-k/

import java.util.*;

class Solution {
  public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> count = new HashMap<>(); // [前綴和， 出現的次數]
      count.put(0, 1); // 子數組和為0的情況有一個，就是一個元素都不取

      int curSum = 0, res = 0;
      for (int num : nums) {
          curSum += num;
          res += count.getOrDefault(curSum - k, 0);
          count.put(curSum, count.getOrDefault(curSum, 0) + 1);
      }
      return res;
  }
}

/**
 * Note: 前綴和+哈希表
 * 用哈希表紀錄當前前綴和出現的次數
 * 1. 遍歷數組，紀錄當前的前綴和(currentSum)
 * 2. 計算currentSum-k，並check它在不在哈希表中，如果在，說明數組某個位置到當前位置的子數組和為k
 * 3. 把currentSum加入哈希表中
 **/