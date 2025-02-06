// Easy
// Map, Counting
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/

import java.util.*;
class Solution {
  // Use Map to store the appear time of each num
  public int findSpecialInteger(int[] arr) {
      int target = arr.length / 4;
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : arr) {
          if (!map.containsKey(num)) {
              map.put(num, 1);
          } else {
              map.put(num, map.get(num) + 1);
              if (map.get(num) > target) return num;
          }
      }
      return arr[0];
  }
}
