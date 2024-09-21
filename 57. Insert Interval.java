// Medium
// Array
// O(n)
// https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> res = new ArrayList<>();

      int start = newInterval[0];
      int end = newInterval[1];

      for (int[] interval : intervals) {
          // 当前在新区间之前（不冲突）
          if (interval[1] < start) {
              res.add(interval);
          }
          // 当前在新区间之后（不冲突）
          else if (interval[0] > end) {
              res.add(new int[] {start, end});
              start = interval[0];
              end = interval[1];
          } 
          else {
              start = Math.min(start, interval[0]);
              end = Math.max(end, interval[1]);
          }
      }
      res.add(new int[] {start, end});
      return res.toArray(new int[res.size()][]);
  }
}

/**
 * 插入區間：在一組不重疊的區間中加入一個新的區間，並保證插入後的區間是有序且不重疊的
 * 
 * 這題思路其實比較簡單：就是分析三種情況 1當前區間在新加入區間之前，也就是當前的end比新區間的start小，這樣是沒有衝突的，直接把區間加入即可
 * 2當前區間在新加入的區間之後，也就是當前的start比新區間的end大，這樣也沒有衝突，先把新區間加入結果，然後更新新區間為當前區間
 * 3新區間和當前區間有重疊，需要合併，更新新區間的start和end為當前區間和新區間的start和end的最小和最大值
 **/