// Medium
// Greedy
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/insert-interval/

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];

        for (int[] interval : intervals) {
            if (interval[1] < start) {
                // If cur' end < new' start -> no conflict
                res.add(interval);
            } else if (interval[0] > end) {
                // merge
                res.add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            } else {
                // update both start(min) and end(max)
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        // add last interval
        res.add(new int[] { start, end });
        return res.toArray(new int[res.size()][]);
    } 
}
