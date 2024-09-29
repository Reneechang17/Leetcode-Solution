// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/two-sum/

import java.util.*;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    if (nums.length == 0 || nums == null)
      return res;

    Map<Integer, Integer> record = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (record.containsKey(temp)) {
        res[1] = i;
        res[0] = record.get(temp);
        break;
      }
      record.put(nums[i], i);
    }
    return res;
  }
}

/**
 * 思路：開一個res數組，大小為2（因為要找兩個數的和為target）
 * basecase：數組為nullor長度為零直接返回res
 * 遍歷數組，用temp紀錄target-nums[i]，check
 * temp是否已經在map中，如果在map，就將res[0]賦值map中找到的temp；res[1]賦值i
 * 如果沒找到，就把這個數放到map中，等待可能的匹配
 **/
