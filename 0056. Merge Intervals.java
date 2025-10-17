// Medium
// Greedy
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/merge-intervals/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // Get first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If the cur start > prev end -> no merge
            if (intervals[i][0] > end) {
                res.add(new int[] { start, end }); // Put prev interval to res
                // update the interval to compare later
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                // merge -> update the end
                end = Math.max(end, intervals[i][1]);
            }
        }
        // add last interval
        res.add(new int[] { start, end });
        return res.toArray(new int[res.size()][]);
    }
}
