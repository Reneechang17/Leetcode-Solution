// Medium
// Array, Prefix Sum, Hash Table
// O(n)
// https://leetcode.com/problems/contiguous-array/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findMaxLength(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);
      int maxLen = 0;
      int prefixSum = 0;

      for(int i = 0; i < nums.length; i++){
          prefixSum += nums[i] == 0 ? -1 : 1;
          if(map.containsKey(prefixSum)){
              maxLen = Math.max(maxLen, i - map.get(prefixSum));
          } else {
              map.put(prefixSum, i);
          }
      }
      return maxLen;
  }
}

/**
 * 思路：前綴和+哈希表
 * 用哈希表來紀錄前綴和出現的次數（索引和次數）
 * 遍歷數組，把零當成-1（這樣0 & 1相加就會是0了）累加前綴和
 * 如果這個前綴和在哈希表中出現過，代表兩個索引之間的和為0，即裡面0和1的數量是相等的
 *   接著計算索引的距離，並更新maxLen
 * 如果這個前綴和沒有出現過，就加入哈希表中
 **/