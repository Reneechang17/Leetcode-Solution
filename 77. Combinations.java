// Medium
// Backtracking
// O(C(n, k))
// https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
    backtracking(n, k, 1);
    return res;
  }

  public void backtracking(int n, int k, int start) {
    // 如果path的長度等於k，代表找到了一個可能的組合
    if (path.size() == k) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = start; i <= n; i++) {
      path.add(i);
      backtracking(n, k, i + 1); // 遞歸：下一個start為i + 1
      path.removeLast(); // 回溯，移除路徑中最後一個元素，嘗試下一個可能
    }
  }
}

/**
 * 給定兩個整數n和k，返回1到n中所有可能k個數的組合
 * 暴力：for循環，但是k過大的話寫下來不科學
 * 優化：用回溯
 **/