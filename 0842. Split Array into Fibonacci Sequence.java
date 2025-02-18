// Medium
// Backtracking, String
// O(2^n)
// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> splitIntoFibonacci(String num) {
    List<Integer> res = new ArrayList<>();
    backtracking(num, res, 0);
    return res;
  }

  public boolean backtracking(String num, List<Integer> res, int index) {
    // 如果到達字符串末尾，並且序列有效、長度大於2，則返回true
    if (index == num.length() && res.size() >= 3) {
      return true;
    }

    // 逐個嘗試每個可能的分割點
    for (int i = index; i < num.length(); i++) {
      // 跳過開頭為0的數
      if (num.charAt(index) == '0' && i > index) {
        break;
      }
      //提取數字，並注意溢出
      long n = Long.parseLong(num.substring(index, i + 1));
      if (n > Integer.MAX_VALUE) {
        break;
      }

      // 檢查是否滿足斐波那契序列的條件
      if (res.size() >= 2 && n > res.get(res.size() - 1) + res.get(res.size() - 2)) {
        break;
      }
      if (res.size() <= 1 || n == res.get(res.size() - 1) + res.get(res.size() - 2)) {
        res.add((int) n);
        // 如果找到，返回true
        if (backtracking(num, res, i + 1)) {
          return true;
        }
        // 回溯
        res.remove(res.size() - 1);
      }
    }
    return false;
  }
}

/**
 * 從字符串num中構造一個斐波那契序列，這個序列至少需要包含三個正整數，並且每個數不能用零開頭，除非這個數本身就是0
 * 斐波那契序列定義：從第三個數開始，每個數都等於其前兩個數的和，即f(n) = f(n - 1) + f(n - 2)
 * 如果構造不了，就返回一個空列表
 * 
 * 思路：這題涉及字符串的分割以及查找分割點，可以用回溯來嘗試
 * 1. 遍歷字符串，跳過開頭為0的數字
 * 2. 嘗試將其分割為斐波那契序列的元素
 * 3. 對於每一個分割的子串，檢查它是否符合斐波那契序列的要求（與前兩個數的和相等，去res的list拿）
 * Note:在提取分割的子串數字時，要注意處理數字長度和整數溢出
 **/