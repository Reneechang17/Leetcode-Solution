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

      // map: store the num and its index
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
          int temp = target - nums[i];
          if (map.containsKey(temp)) {
              res[1] = i; // res[1] put the index of the current element
              res[0] = map.get(temp); // res[0] put the index of the element that can sum up to target
              break;
          }
          map.put(nums[i], i); // add the current element and its index to the map
      }
      return res;
  }
}
