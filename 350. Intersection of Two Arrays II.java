// Easy
// Hash Table, Array
// O(m + n)
// https://leetcode.com/problems/intersection-of-two-arrays-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> counter = new HashMap<>();
      for (int num : nums1) {
          counter.put(num, counter.getOrDefault(num, 0) + 1);
      }
      
      List<Integer> t = new ArrayList<>();
      for(int num : nums2){
          if(counter.getOrDefault(num, 0) > 0){
              t.add(num);
              counter.put(num, counter.get(num) - 1);
          }
      }
      int[] res = new int[t.size()];
      for(int i = 0; i < res.length; i++){
          res[i] = t.get(i);
      }
      return res;
  }
}

/**
 * 思路：
 * 1. 先定義哈希表遍歷nums1元素出現次數
 * 2. 再定義列表t（用於裝nums1 & nums2都有出現的）
 * 3. 遍歷nums2，如果遇到nums1出現的，就裝入t，並更新nums1的哈希表
 * 4. 最後新開數組遍歷t
 **/