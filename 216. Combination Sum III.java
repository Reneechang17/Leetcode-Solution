// Medium
// Backtracking
// O(9^k)
// https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
      backtracking (n, k, 1, 0);
      return res;
  }

  public void backtracking(int target, int k, int start, int curSum) {
      if (curSum > target) return; // 剪枝

      if (path.size() == k) {
          if (curSum == target) res.add(new ArrayList<>(path));
          return;
      }

      for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
          path.add(i);
          curSum += i;
          backtracking(target, k, i + 1, curSum);
          path.removeLast();
          curSum -= i;
      }
  }
}

/**
 * 組合總和問題：找出所有相加和為n的k個數的組合，只允許1-9正整數且不存在重複的數字
 * 
 * 可以想成：樹的深度為k（遞歸），1-9就是樹的寬度
 * 剪枝：當當前sum已經大於target，直接return
 *      遞歸中的起始位置的上界也可以剪枝：用k - path.size()：計算還需要多少個數字才能達到組合中所需的數字數量k
 **/