// Hard
// Sort, Array
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/employee-free-time/

import java.util.*;

class Solution {
  // Problem involves merging intervals to find free time:
  // 1. Flatten the schedule by merging overlapping intervals from all employees
  // 2. Use a priority queue or sort the intervals based on start time to simplify merging
  // 3. After merging, identify gaps between consecutive intervals, which represent free times
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
      List<Interval> intervals = new ArrayList<>();
      List<Interval> res = new ArrayList<>();
      // put all schedule into a single list
      for (List<Interval> interval : schedule) {
          intervals.addAll(interval);
      }
      // sort intervals by start time
      intervals.sort((a, b) -> a.start - b.start);
      // merge overlapping intervals
      Interval prev = intervals.get(0);
      for (int i = 1; i < intervals.size(); i++) {
          Interval cur = intervals.get(i);
          if (cur.start <= prev.end) {
              // merge intervals
              prev.end = Math.max(prev.end, cur.end);
          } else {
              // find gap, add it to res
              res.add(new Interval(prev.end, cur.start));
              prev = cur;
          }
      }
      return res;
  }
}
