// Medium
// String, Backtracking
// O(n^4)
// https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

class Solution {
  List<String> res = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
      StringBuilder sb = new StringBuilder(s);
      backtracking (sb, 0, 0);
      return res;
  }

  private void backtracking(StringBuilder s, int start, int dotCount) {
      // 已經放了三個點的話，就已經分四段了
      if (dotCount == 3) {
          if (isValid(s, start, s.length() - 1)) {
              res.add(s.toString());
          }
          return;
      }
      for (int i = start; i < s.length(); i++) {
          if (isValid(s, start, i)) {
              s.insert(i + 1, '.');
              // 回溯要把加入的dot的位置也算進去
              backtracking(s, i + 2, dotCount + 1);
              s.deleteCharAt(i + 1);
          } else {
              break;
          }
      }
  }

  // 驗證一段s[start, end]是不是有效的ip地址段
  private boolean isValid (StringBuilder s, int start, int end) {
      if (start > end) return false;
      // 起始數字為0並且長度>1 return false
      if (s.charAt(start) == '0' && start != end) return false;

      int num = 0;
      // 遍歷這個數字
      for (int i = start; i <= end; i++) {
          // 將字符轉換成數字
          int digit = s.charAt(i) - '0';
          // 累加到num
          num = num * 10 + digit;
          // 當數字大於255 return false
          if (num > 255) return false;
      }
      return true;
  } 
}

/**
 * 復原Ip地址
 * 
 * 可以先看一下回溯的切割問題
 * 
 * 遞歸思路：
 * 1. 如果已經放了三個點的話，代表已經分割成四段，可以收到res中
 * 2. 驗證start到i是否valid，如果valid的話就把dot加到i+1的位置，然後回溯
 * Note：遞歸調用時，記得下一層的start要從i+2的位置開始（要把dot的位置算上，並且dot的數量+1）
 * 回溯的時候也要把分隔符和dotcount都減掉
 * 
 * 驗證子串是否合法：
 * 1. 0開頭並且長度超過1 false
 * 2. 有非正整數 false
 * 3. 遍歷完累加 大於255 false
 **/