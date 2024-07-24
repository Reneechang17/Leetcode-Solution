// Hard
// Prefix, Hash Table
// O(n)
// https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int waysToPartition(int[] nums, int k) {
    int n = nums.length;
    int[] prefixSum = new int[n];
    prefixSum[0] = nums[0]; // 初始化前綴和數組第一個元素為數組第一個元素

    // 統計前綴和在右側出現的次數
    Map<Integer, Integer> countRight = new HashMap<>();
    // 注意這裡只有遍歷到n-1，因為我們還在查找分割點
    for (int i = 0; i < n - 1; ++i) {
      countRight.put(prefixSum[i], countRight.getOrDefault(prefixSum[i], 0) + 1);
      // 計算下一個前綴和
      prefixSum[i + 1] = prefixSum[i] + nums[i + 1];
    }

    int res = 0;
    // 如果整個數組的和是偶數
    if (prefixSum[n - 1] % 2 == 0) {
      // 查找可以直接分割的方法數
      res = countRight.getOrDefault(prefixSum[n - 1] / 2, 0);
    }

    // 統計前綴和在左側出現的次數
    Map<Integer, Integer> countLeft = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      // 計算每個元素改變後的差值
      int delta = k - nums[i];

      // 如果改變後的總和為偶數
      if ((prefixSum[n - 1] + delta) % 2 == 0) {
        // 計算左右兩邊的方法數和
        int total = countLeft.getOrDefault((prefixSum[n - 1] + delta) / 2, 0)
            + countRight.getOrDefault((prefixSum[n - 1] - delta) / 2, 0);
        res = Math.max(res, total); // 更新結果
      }

      // 更新左右側哈希表
      countLeft.put(prefixSum[i], countLeft.getOrDefault(prefixSum[i], 0) + 1);
      countRight.put(prefixSum[i], countRight.getOrDefault(prefixSum[i], 0) - 1);
    }
    return res;
  }
}

/**
 * 這題的目標是找出通過修改數組中一個元素的值，能最大化以某種方式分割數組的次數
 * 具體來說就是找到一種方式，通過這種方式分割數組，使得分割後兩個部分的和的差為給定的整數k
 * 意思就是你可以選擇數組中的一個元素並且改變它的值（改變值後的元素仍要保持為整數），改變元素值之後，需要找到一種分割數組的方式，使得分割後的兩部分的和的差等於k
 * 返回能夠找到滿足條件的分割方法的最大數量
 * 
 * 核心問題：這題需要考慮兩種情況
 * 1. 不改變任何元素：直接找有沒有分割點可以使分割後的兩部分和的差為k
 * 2. 改變一個元素之後：嘗試改變其中一個元素，每次改變之後，重新尋找是否有分割點可以使得分割後兩部分和的差為k
 * => 可以發現我們會不斷有找的過程，由於這題的數據量比較大，我們可以考慮用哈希表優化查詢的時間到O(1)，不然寫很多for查找會超時
 * 
 * 具體思路看代碼的註釋
 **/