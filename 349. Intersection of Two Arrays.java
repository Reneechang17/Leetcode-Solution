// Easy
// Hash Table, Array
// O(m + n)
// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
      int[] hash1 = new int[1001];
      int[] hash2 = new int[1001];
      for(int i : nums1){
          hash1[i]++;
      }
      for(int i : nums2){
          hash2[i]++;
      }
      List<Integer> res = new ArrayList<>();
      for(int i = 0; i < 1001; i++){
          if(hash1[i] > 0 && hash2[i] > 0){
              res.add(i);
          }
      }
      int idx = 0;
      int[] resList = new int[res.size()];
      for(int i : res){
          resList[idx] = i;
          idx++;
      }
      return resList;
  }
}

/**
 * 思路：
 * 1. 遍歷nums1 和 nums2，統計每個元素出現的次數（哈希表）
 * 2. 如果同一個數字在兩個數組中都至少出現一次，就加入res
 * 3. 定義最終resList，遍歷res，將遍歷到的i賦值到resList的index中
 **/