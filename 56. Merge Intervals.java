// Medium
// Greedy
// Time:O(nlogn), sorting+iterate the arr 
// Space:O(n), store the result
// https://leetcode.cn/problems/merge-intervals/

import java.util.*;

class Solution {
    // We can first to sort the intervals by start time
    // Iterate intervals, compare current with previous, so we can get the first interval
    //   and go through from second interval(i = 1)
    // If overlapped(cur start > prev end), update end time as bigger one(only sort start time)
    // If no overlapped, we add prev one in res, and update the cur start and end as cur
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // sorting by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // get first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{start, end}); // add last one
        return res.toArray(new int[res.size()][]);
    }
}
