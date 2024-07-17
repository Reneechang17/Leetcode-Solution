// Medium
// Backtracking
// O(2^n)
// https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<String>> res = new ArrayList<>();
  Deque<String> deq = new LinkedList<>();

  public List<List<String>> partition(String s) {
      backtracking (s, 0);
      return res;
  }
  public void backtracking(String s, int start) {
      if (start >= s.length()) {
          res.add(new ArrayList<>(deq));
          return;
      }
      for (int i = start; i < s.length(); i++) {
          if (isPalindrome(s, start, i)) {
              String str = s.substring(start, i + 1);
              deq.add(str);
          } else {
              continue;
          }
          backtracking(s, i + 1);
          deq.removeLast();
      }
  }
  public boolean isPalindrome(String s, int start, int end) {
      for (int i = start, j = end; i < j; i++, j--) {
          if(s.charAt(i) != s.charAt(j)) {
              return false;
          }
      }
      return true;
  }
}

/**
 * 分割回文串：將給定的字符串s分割成子串，使得每個子串都是回文子串
 * 
 * hint：回文串分割問題的回溯搜索和組合問題的回溯相似
 * 怎麼檢查是否為回文串：定義雙指針在頭尾，如果前後指針指向的元素不相等，就不是回文子串
 **/