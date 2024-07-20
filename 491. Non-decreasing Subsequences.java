// Medium
// Backtracking, Hash Table
// O(2^n)
// https://leetcode.com/problems/non-decreasing-subsequences/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> findSubsequences(int[] nums) {
      backtracking(nums, 0);
      return res;
  }

  public void backtracking(int[] nums, int start) {
      if (path.size() >= 2) {
          res.add(new ArrayList<>(path));
      }
      HashSet<Integer> set = new HashSet<>();
      for (int i = start; i < nums.length; i++) {
          // 檢查確保子序列元素的遞增（最後一個大於當前就破壞遞增）、唯一（set如果有的話就重了）
          if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || set.contains(nums[i])) {
              continue;
          }
          set.add(nums[i]);
          path.add(nums[i]);
          backtracking(nums, i + 1);
          path.removeLast();
      }
  }
}

/**
 * 遞增子序列
 * 
 * 這題需要在遍歷的過程中確保 1. 遞增 2. 元素的唯一性
 * 遞增就是判斷已經在path中的最後一個是否已經大於當前遍歷到的元素
 * 唯一性的話，這題不是使用used數組，而是使用set，子序列的構建是動態的，元素是否被選擇取決於之前選擇的元素（是否能遞增）
 * 因此元素的使用不只是取決於是否在之前的遞歸步驟用過，還取決於它與之前元素的大小比較，這點used數組不夠用
 * 
 * HashSet雖然佔內存但是可以O(1)增刪查改，並且這題used數組確實不夠判斷遞增這個條件
 **/