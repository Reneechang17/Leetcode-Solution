// Medium
// Greedy
// O(n logn)
// Similar: 452
// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
      int n = intervals.length;
      Arrays.sort(intervals, (a, b) -> {
          return Integer.compare(a[0], b[0]);
      });

      int count = 1;
      for (int i = 1; i < n; i++) {
          if (intervals[i][0] < intervals[i - 1][1]) {
              intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
              continue;
          } else {
              count++;
          }
      }
      return n - count;
  }
}

/**
 * 這題的思路和452比較像，找最少要移除多少intervals可以讓剩下的成為無重疊區間
 * 
 * 可以轉換成用區間總數-非重疊區間的個數就是需要移除的區間個數
 **/