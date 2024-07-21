// Medium
// Array, Sorting
// O(n logn)
// https://leetcode.com/problems/h-index/

import java.util.Arrays;

class Solution {
  public int hIndex(int[] citations) {
      Arrays.sort(citations);
      int n = citations.length;
      int idx = 0;

      for (int i = 0; i < n; i++) {
          int cur = Math.min(citations[i], n - i);
          if (cur > idx) {
              idx = cur;
          }
      }
      return idx;
  }
}

/**
 * 給定一個數組表示科學家論文被引用次數，需要計算並返回該科學家的H指數
 * 
 * H指數的定義：一個人的h指數指他有h篇論文分別至少被引用了h次
 * 
 * 思路：排序法
 * 先將citations排序
 * 然後從後往前遍歷數組，找到最大的i使得citations[i] >= i + 1
 **/