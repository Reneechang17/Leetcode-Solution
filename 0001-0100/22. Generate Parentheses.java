// Medium
// Backtracking
// O(4^n / sqrt(n))
// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      backtracking(res, "", 0, 0, n);
      return res;
  }

  private void backtracking(List<String> res, String current, int open, int close, int max) {
      if(current.length() == max * 2) {
          res.add(current);
          return;
      }

      if(open < max) {
          backtracking(res, current + "(", open + 1, close, max);
      }
      if(close < open) {
          backtracking(res, current + ")", open, close + 1, max);
      }
  }
}

/**
 * 生成n對()的所有排列組合方式
 * 
 * 所以總長度應該是n * 2 -> 剛好匹配到這個長度時，收集到res中
 * 1. 左括號和右括號的數量要相等（只有一個不可以，左括號必須早於右括號出）
 * -> 插入右括號的數量不能多餘當前的左括號
 * 2. 已經使用的左括號的數量小於n的時候，才可以考慮加左括號
 * 3. 當前右括號的數量小於左括號的時候，才可以加右括號
 **/