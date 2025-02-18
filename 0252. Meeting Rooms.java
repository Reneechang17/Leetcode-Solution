// Easy
// Array, Sort
// Time:O(nlogn), Space:O(logn)
// https://leetcode.cn/problems/meeting-rooms/

import java.util.Arrays;

class Solution {
  public boolean canAttendMeetings(int[][] intervals) {
      if (intervals.length == 0) return true;
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      for (int i = 1; i < intervals.length; i++) {
          // if prev end > cur start -> conflict
          if (intervals[i - 1][1] > intervals[i][0]) {
              return false;
          }
      }
      return true;
  }
}
