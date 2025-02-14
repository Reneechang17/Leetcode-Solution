// Easy
// Array
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/decompress-run-length-encoded-list/

import java.util.*;
class Solution {
  public int[] decompressRLElist(int[] nums) {
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < nums.length; i += 2) {
          int freq = nums[i], val = nums[i + 1];
          for (int j = 0; j < freq; j++) {
              res.add(val);
          }
      }
      // convert list to arr
      return res.stream().mapToInt(i -> i).toArray();
  }
}
