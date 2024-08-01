// Medium
// Greedy
// O(nlogn)
// https://leetcode.com/problems/merge-intervals/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {
      List<int[]> res = new LinkedList<>();
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

      int start = intervals[0][0];
      int rightBound = intervals[0][1];

      for (int i = 1; i < intervals.length; i++) {
        // 沒重疊，加到res
          if (intervals[i][0] > rightBound) {
              res.add(new int[]{start, rightBound});

              // update
              start = intervals[i][0];
              rightBound = intervals[i][1];
            } else {
            // 如果重疊，就更新rightBound為當前區間和之前紀錄的結束點中較大的
              rightBound = Math.max(rightBound, intervals[i][1]);
          }
      }
      res.add(new int[]{start, rightBound});
      return res.toArray(new int[res.size()][]);
  }
}

/**
 * 這題的套路和435和452差不多，但是這題是合併區間，一樣要check是否有重疊（當前的start是不是大於前一個end）
 **/