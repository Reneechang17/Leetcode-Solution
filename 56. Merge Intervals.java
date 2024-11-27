// Medium
// Greedy
// Time:O(nlogn), sorting+iterate the arr 
// Space:O(n), store the result
// https://leetcode.cn/problems/merge-intervals/

import java.util.*;

class Solution {
    // if the cur's start < prev's end -> merge
    // if they can be merge, we can modified the intervals with[prev'start, cur'end]
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // first one
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // cur' start > prev's end -> no conflict
            if (intervals[i][0] > end) {
                res.add(new int[] {start, end});

                // update start and end
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                // conflict -> merge
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[] {start, end}); // add last one
        return res.toArray(new int[res.size()][]);
    }
}
