// Easy
// Hash Table
// O(N)
// https://leetcode.com/problems/degree-of-an-array/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findShortestSubArray(int[] nums) {
      Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>(), last = new HashMap<>();
      int res = nums.length, degree = 0;

      for (int i = 0; i < nums.length; i++) {
          first.putIfAbsent(nums[i], i);
          count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
          last.put(nums[i], i);
          degree = Math.max(degree, count.get(nums[i]));
      }

      for (int key : count.keySet()) {
          if (count.get(key) == degree) {
              res = Math.min(res, last.get(key) - first.get(key) + 1);
          }
      }
      return res;
  }
}

/**
 * 給定一個非空負整數數組nums，其degree指的是數組中任意一個元素出現最高的頻率，目標是找到與原數組具有相同度數的最短連續子數組
 * 
 * 思路：一樣是用哈希表優化查找的過程，可以使用一個哈希表count來紀錄每個元素在數組中出現的次數
 * 再另外開兩個哈希表紀錄每個元素第一次出現和最後一次出現的位置
 * 
 * 然後遍歷count中的每個元素（即key），找到出現次數和degree次數相同的元素
 * 對於每個這樣的元素，計算它的最短連續子數組長度，即last[key] - first[key] + 1,因為可能會有比較多所以用一個遍歷紀錄不斷找就行
 **/