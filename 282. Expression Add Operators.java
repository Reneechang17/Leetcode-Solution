// Hard
// Backtracking, DFS
// O(n * 4^n)
// https://leetcode.com/problems/expression-add-operators/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> addOperators(String num, int target) {
      List<String> res = new ArrayList<>();
      if (num == null || num.length() == 0) {
          return res;
      }
      backtracking(res, "", num, target, 0, 0, 0);
      return res;
  }

  private void backtracking(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
      if (pos == num.length()) {
          if (target == eval) {
              res.add(path);
          }
          return;
      }

      for (int i = pos; i < num.length(); i++) {
          if (i != pos && num.charAt(pos) == '0') break;
          long cur = Long.parseLong(num.substring(pos, i + 1));

          // 第一個數字不需要操作（不需要插入operation sign）
          if (pos == 0) {
              backtracking(res, path + cur, num, target, i + 1, cur, cur);
          } else {
              backtracking(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
              backtracking(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
              backtracking(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
          } 
      }
  }
}

/**
 * 要求在一個沒有操作符的數字字符串中添加加號、減號、乘號，使得表達式的結果等於給定的目標值
 * 
 * 這題需要探索所有可能的操作符插入方式，可以使用回溯+DFS，用遞歸嘗試每種可能的操作符插入，並使用回溯來撤銷之前的選擇，以嘗試新的可能（路徑）
 * 需要注意乘法，它的優先級高於加法、減法，當遍歷到乘法時，需要回溯到上一個操作符，計算乘法再繼續
 **/