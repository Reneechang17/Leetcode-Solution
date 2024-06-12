// Medium
// Array, Hash Table
// O(n^2)
// https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      int res = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i : nums1) {
          for (int j : nums2) {
              int sum = i + j;
              int count = map.getOrDefault(sum, 0);
              map.put(sum, count + 1);
          }
      }
      for (int i : nums3) {
          for (int j : nums4) {
              res += map.getOrDefault(0 - i - j, 0);
          }
      }
      return res;
  }
}

/**
 * 思路：
 * 先遍歷nums1和nums2，用哈希表紀錄所有可能的兩數之和出現的次數
 * Note：每次計算出一個總和，先去哈希表找這個總和出現的次數，再去哈希表更新
 * 再遍歷nums3和nums4，查找與當前組合的和相加為0的組合，再把結果加到最後結果中
 **/