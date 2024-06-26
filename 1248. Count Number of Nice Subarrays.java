// Medium
// Hash Table, Prefix
// O(N)
// https://leetcode.com/problems/count-number-of-nice-subarrays/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
    // 用哈希表紀錄每個前綴和出現的次數
    Map<Integer, Integer> cnt = new HashMap<>();
    // 初始化一個奇數都沒有出現的情況出現一次
    cnt.put(0, 1);

    int sum = 0, res = 0;

    for (int num : nums) {
      // 驗證是否為奇數
      if (num % 2 == 1)
        sum++;
      // 對於每個位置的前綴和（當前位置包含的奇數總數），查找cnt[當前前綴和（即sum） - k]
      res += cnt.getOrDefault(sum - k, 0);
      // 更新當前前綴和到哈希表中
      cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}

/**
 * Nice Subarray 指的是某個連續子數組剛好有k個奇數
 * 用前綴和 + 哈希表來解決
 **/