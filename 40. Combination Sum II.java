// Medium
// Backtracking
// O(2^n) （實際情況應小於，因為有剪枝）
// Similar: 39
// https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  LinkedList<Integer> path = new LinkedList<>();
  List<List<Integer>> res = new ArrayList<>();
  boolean[] used;
  int sum = 0;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      used = new boolean[candidates.length];
      Arrays.sort(candidates);
      backtracking(candidates, target, 0);
      return res;
  }

  public void backtracking(int[] candidates, int target, int start) {
      if (sum == target) {
          res.add(new ArrayList<>(path));
      }
      // 從start開始遍歷
      for (int i = start; i < candidates.length; i++) {
          if (sum + candidates[i] > target) {
              break;
          }
          if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
              continue;
          }
          used[i] = true;
          sum += candidates[i];
          path.add(candidates[i]);
          backtracking(candidates, target, i + 1);
          used[i] = false;
          sum -= candidates[i];
          path.removeLast();
      }
  }
}

/**
 * 組合總和問題：給定一個候選人編號的集合candidates和一個目標數target，找出candidates中所有可以使數字和為target的組合
 * 並且candidates中每個數字在每個組合中只能使用一次（也就是解答中不能出現重複的組合）
 * 
 * 看似要去重，實際上這題用set去重直接超時 => 優化，用一個bool的數組標記一下是否使用過
 * 可以想成一個樹去搜索，樹的去重有兩個方式 1.樹層去重 2.樹枝去重
 * 這題要求在同一個組合內可以重，但是兩個組合不能重複，所以是樹層去重（記得先排序）
 * 
 * 解法思路
 * 1. 用一個used數組來紀錄同一個樹枝上的元素是否使用過
 * 2. 終止條件：當sum已經大於target時，break；當sum等於target時收集
 * 3. 單層搜索條件：當candidates[i] == candidates[i - 1]，並且used[i - 1] == false
 *    說明：如果當前數字和前一個數字相同，並且前一個數字在當前遞歸層級沒有被使用，則跳過
 **/