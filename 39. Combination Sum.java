// Medium
// Backtracking
// O(2^n)
// Similar: 77
// https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(candidates);

      backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
      return res;
  }
  public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int start) {
      if (sum == target) {
          res.add(new ArrayList<>(path));
          return;
      }

      for (int i = start; i < candidates.length; i++) {
          if (sum + candidates[i] > target) break; // 剪枝
          path.add(candidates[i]);
          backtracking(res, path, candidates, target, sum + candidates[i], i);
          path.removeLast();
      }
  }
}

/**
 * 組合總和問題
 * 給定一個無重複元素的數組和一個目標數，找出candidates中可以使數字和為目標的所有不同組合，並以列表形式返回
 * 可以按任意順序返回這些組合。數組中的同一個數字可以無限制重複被選取，至少有一個數字的被選取數量不同，則兩種組合是不同的
 * 
 * 思路：排序+回溯+剪枝
 * 
 * 剪枝：當sum+candidates[i]大於target時直接break
 **/