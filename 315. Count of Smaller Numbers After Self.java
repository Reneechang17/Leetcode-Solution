// Hard
// Binary Search
// O(nlogn)
// https://leetcode.cn/problems/count-of-smaller-numbers-after-self/

import java.util.*;

class Solution {
  public List<Integer> countSmaller(int[] nums) {
      List<Integer> res = new ArrayList<>();
      List<Integer> sortedList = new ArrayList<>();

      for (int i = nums.length - 1; i >= 0; i--) {
          int num = nums[i];
          int insertPos = binarySearch(sortedList, num);
          res.add(insertPos);
          sortedList.add(insertPos, num);
      }

      Collections.reverse(res);
      return res;
  }

  private int binarySearch(List<Integer> sortedList, int target) {
      int left = 0, right = sortedList.size();
      while (left < right) {
          int mid = (left + right) >> 1;
          if (sortedList.get(mid) >= target) {
              right = mid;
          } else {
             left = mid + 1;
          }
      }
      return left;
  }
}