// Medium
// Backtracking
// O(n 2^n)
// similar: 47
// https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();
  boolean[] used;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
      if (nums.length == 0) {
          res.add(path);
          return res;
      }
      Arrays.sort(nums);
      used = new boolean[nums.length];
      subsetCheck(nums, 0);
      return res;
  }

  public void subsetCheck(int[] nums, int start) {
      res.add(new ArrayList<>(path));
      if (start >= nums.length) {
          return;
      }

      for (int i = start; i < nums.length; i++) {
          if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
              continue;
          }

          path.add(nums[i]);
          used[i] = true;
          subsetCheck(nums, i + 1);
          path.removeLast();
          used[i] = false;
      }
  }
}

/**
 * 子集問題
 * 
 * 和78的差異：78題的數組元素不重複，但是這題的數組元素是重複的
 * 那麼就要避免產生重複的數組：用used來表示是否使用，避免在同一次遞歸重複使用同一個元素（檢查當前元素是否和前一個元素相同，並且前一個元素是否被使用）
 * Note：數組要記得先排序
 **/