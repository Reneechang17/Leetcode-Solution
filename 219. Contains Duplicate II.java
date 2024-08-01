// Easy
// Hash Table, Array
// O(n)
// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
          if (map.containsKey(nums[i])) {
              if (i - map.get(nums[i]) <= k) {
                  return true;
              }
          }
          map.put(nums[i], i);
      }
      return false;
  }
}

/**
 * 判斷一個數組中是否存在兩個不同索引i和j，使得nums[i] == nums[j]，並兩者之間的差的絕對值最大為k
 * 
 * 思路：可以用哈希表紀錄每個元素最後一次出現的索引，對於每個元素，檢查是否存在另一個相同的元素，其差值不超過k
 **/