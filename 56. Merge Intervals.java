// Medium
// Greedy
// O(nlogn)
// https://leetcode.cn/problems/merge-intervals/

import java.util.*;

class Solution {
  public int[][] merge(int[][] intervals) {
      // 當前的start不能大於前一個的end
      List<int[]> res = new ArrayList<>();
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

      int start = intervals[0][0];
      int right = intervals[0][1];

      for (int i = 1; i < intervals.length; i++) {
          // 如果沒有重疊
          if (intervals[i][0] > right) {
              res.add(new int[]{start, right});

              // 更新start和right
              start = intervals[i][0];
              right = intervals[i][1];
          } else {
              right = Math.max(right, intervals[i][1]);
          }
      }
      res.add(new int[]{start, right});
      return res.toArray(new int[res.size()][]);
  }
}
