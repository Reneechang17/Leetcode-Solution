// Medium
// Backtracking
// O(2^n)
// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
      subsetCheck (nums, 0);
      return res;
  }
  public void subsetCheck(int[] nums, int start) {
      res.add(new ArrayList<>(path));
      if (start >= nums.length) {
          return;
      }

      for (int i = start; i < nums.length; i++) {
          path.add(nums[i]);
          subsetCheck(nums, i + 1);
          path.removeLast();
      }
  }
}

/**
 * 子集問題：給定一個數組，數組中的元素互不相同，返回這個數組所有可能的子集
 * 解集不能包含重複的子集，可以按照任意順序返回解集
 * 
 * 終止條件：當start>數組長度的時候
 * 求子集不能做剪枝，要遍歷整棵樹，找所有可能性
 **/