// Medium
// Greedy
// O(n logn)
// Similar: 452
// https://leetcode.cn/problems/non-overlapping-intervals/

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int count = 1;
        for (int i = 1; i < n; i++) {
            // 如果當前區間和前一個區間重疊
            if (intervals[i][0] < intervals[i - 1][1]) {
                // 保留右端較小的區間，減少後續重疊的可能性
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                continue;
            } else {
                // 如果不重疊，更新計數
                count++;
            }
        }
        return n - count;
    }
}