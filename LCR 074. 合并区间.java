// Medium
// Interval, Sorting
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/SsGoHC/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // sort by start time
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        // get first interval
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{start, end}); // add last interval
        return res.toArray(new int[res.size()][]);
    }
}
