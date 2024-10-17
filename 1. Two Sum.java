// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/two-sum/

import java.util.*;

class Solution {
  public int[] twoSum(int[] nums, int target) {
      int[] res = new int[2];
      if (nums == null || nums.length == 0) {
          return res;
      }

      // map存放元素以及其出現的索引
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
          int temp = target - nums[i];
          if (map.containsKey(temp)) {
              res[1] = i; // res[1]放的是當前元素的索引
              res[0] = map.get(temp); // res[0]放的是和當前元素湊成target的元素的索引
              break;
          }
          map.put(nums[i], i); // 將當前元素和當前元素的索引放入map中
      }
      return res;
  }
}
