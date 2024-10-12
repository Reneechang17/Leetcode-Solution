// Medium
// Backtracking
// O(k * logn) 
// https://leetcode.cn/problems/factor-combinations/

import java.util.*;

class Solution {
  public List<List<Integer>> getFactors(int n) {
      // 找所有因子的組合 -> 回溯 找所有可能性
      List<List<Integer>> res = new ArrayList<>();
      backtracking(n, 2, new ArrayList<>(), res);
      return res;
  }

  private void backtracking(int n, int start, List<Integer> cur, List<List<Integer>> res) {
      if (n == 1) {
          // 只有當當前組合超過一個因子的時候才會加入結果列表
          if (cur.size() > 1) {
              res.add(new ArrayList<>(cur));
          }
          return;
      }

      for (int i = start; i <= Math.sqrt(n); i++) {
          // 如果i是n的因子
          if (n % i == 0) {
              cur.add(i);
              backtracking(n / i, i, cur, res);
              cur.remove(cur.size() - 1);
          }
      }

      // 檢查n自己是不是有效因子
      if (n >= start && !cur.isEmpty()) {
          cur.add(n);
          res.add(new ArrayList<>(cur));
          cur.remove(cur.size() - 1);
      }
  }
}
