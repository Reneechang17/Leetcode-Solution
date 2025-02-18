// Medium
// Intervals
// O(n)
// https://leetcode.cn/problems/insert-interval/

import java.util.*;

class Solution {
    // there are three possible of the newInterval:
    // 1. after the prev one, so the cur' end < new' start -> no conflict
    // 2. before the prev one, so the cur' start > new' end -> no conflict
    // 3. conflict -> update the new start and end
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {
            if (interval[1] < start) {
                res.add(interval);
            } else if (interval[0] > end) {
                res.add(new int[]{start, end});
                // update the start and end
                start = interval[0];
                end = interval[1];
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        // add last one 
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
