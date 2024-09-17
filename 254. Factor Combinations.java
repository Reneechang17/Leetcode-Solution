// Medium
// Backtracking
// O(k * logn) 
// https://leetcode.com/problems/factor-combinations/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> getFactors(int n) {
      List<List<Integer>> res = new ArrayList<>();
      backtracking(n, 2, new ArrayList<>(), res);
      return res;
  }

  private void backtracking(int n, int start, List<Integer> cur, List<List<Integer>> res) {
      if (n == 1) {
          if (cur.size() > 1) {
              res.add(new ArrayList<>(cur)); // 必須至少有兩個因子
          }
          return;
      }

      for (int i = start; i <= Math.sqrt(n); i++) {
        if (n % i == 0) { // 如果i是n的因子
          cur.add(i);
          backtracking(n / i, i, cur, res); // 遞歸處理剩下的部分
          cur.remove(cur.size() - 1); // 回溯，移除最後一個因子
        }
      }
      
      // 確保cur不是空的才進行n本身的檢查：假設n本身也是一個有效因子
      if (n >= start && !cur.isEmpty()) {
          cur.add(n);
          res.add(new ArrayList<>(cur));
          cur.remove(cur.size() - 1);
      }
  }
}

/**
 * 因子的組合：給定一個整數n，找到所有可能的因子組合，使得這些因子的乘積等於0
 * 
 * 這題的本質是找所有可能的因子組合，可以聯想到回溯嘗試所有可能
 * 具體：從較小的因子開始，逐步分解n，並在每一步中選擇一個因子，將其加入當前的組合中
 * 遞歸分解剩下的部分，知道分解完成或是沒有合適的因子為止
 **/