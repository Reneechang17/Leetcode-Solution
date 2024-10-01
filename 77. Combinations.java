// Medium
// Backtracking
// O(C(n, k))
// https://leetcode.cn/problems/combinations/

import java.util.*;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
      backtracking(n, k, 1);
      return res;
  }

  public void backtracking (int n, int k, int start) {
      // 當收集的路徑數量為k，則收到res中
      if (path.size() == k) {
          res.add(new ArrayList<>(path));
          return;
      }

      for (int i = start; i <= n; i++) {
          path.add(i);
          backtracking(n, k, i + 1);
          path.removeLast();
      }
  }
}

/**
 * 給定兩個整數n和k，返回1到n中所有可能k個數的組合
 * 暴力：for循環，但是k過大的話寫下來不科學
 * 優化：用回溯
 **/