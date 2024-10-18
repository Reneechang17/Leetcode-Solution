// Medium
// Hash Table
// O(n)
// https://leetcode.cn/problems/longest-consecutive-sequence/

import java.util.*;

class Solution {
  // 因為要O(n)，代表基本的排序是不能做到的，需要有更快的存儲獲取元素的方法 -> 哈希表
  public int longestConsecutive(int[] nums) {
      // 將數組的元素放入set中去重
      Set<Integer> set = new HashSet<>();
      for (int n : nums) {
          set.add(n);
      }
      // 遍歷set的元素，首先一個數字能作為序列開始的條件是：set中沒有num-1
      int res = 0;
      for (int n : set) {
          if (!set.contains(n - 1)) {
              int curNum = n;
              int curRes = 1;

              // 如果set中不斷有num+1則是有效的數字
              while(set.contains(curNum + 1)){
                  curNum++;
                  curRes++;
              }

              res = Math.max(res, curRes);
          }
      }
      return res;
  }
}
