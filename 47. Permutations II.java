// Medium
// Backtracking
// O(n!)
// similar: 46, 90
// https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();
  boolean[] used;

  public List<List<Integer>> permuteUnique(int[] nums) {
      used = new boolean[nums.length];
      Arrays.sort(nums);
      backtracking (nums, used);
      return res;
  }

  public void backtracking(int[] nums, boolean[] used) {
      if (path.size() == nums.length) {
          res.add(new ArrayList<>(path));
          return;
      }
      for (int i = 0; i < nums.length; i++) {
          if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
              continue;
          }
          if (used[i] == false) {
              used[i] = true;
              path.add(nums[i]);
              backtracking(nums, used);
              path.removeLast();
              used[i] = false;
          }
      }
  }
}

/**
 * 全排列II
 * 
 * 這題和46的差別在於：數組的元素可能有重複的
 * 那就多了一步：需要去重 -> set or used[]
 * 
 * 需要判斷
 * 1. i > 0:確認當前的i有前一個元素，防止索引越界
 * 2. nums[i] == nums[i - 1] : 確認當前元素和其前一個元素是否相同，在兩個元素相同的情況下我們才需要特別注意去重
 * 3. ！used[i - 1]: 檢查前一個相同元素 i-1 有沒有在當前的遞歸中被使用。如果沒有被使用（used[i - 1] == false)，這表示在構建當前的排列時，已經回溯並且移除了前一個相同的元素
 * 白話文：代表我們已經回溯過前一個元素了，現在在相同的遞歸層遇到了一個相同的元素nums[i]， 如果我們允許nums[i]再被使用，只會得到和used[i - 1]那時候一樣的結果，重複了
 **/