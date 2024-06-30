import java.util.HashMap;
import java.util.Map;

// Medium
// Prefix, Hash Table
// O(n)
// Similar: 974
// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
  public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> count = new HashMap<>();
      count.put(0, 1);

      int currentSum = 0, res = 0;
      for(int num : nums){
          currentSum += num;
          res += count.getOrDefault(currentSum - k, 0);
          count.put(currentSum, count.getOrDefault(currentSum, 0) + 1);
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