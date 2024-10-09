// Medium
// Array
// O(n)
// https://leetcode.cn/problems/insert-interval/

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 有三種可能的情況
        // 1. 當前的區間在新區間之前 -> 不衝突 -> 當前的end小於新區間的start
        // 2. 當前的區間在新區間之後 -> 不衝突 -> 當前的start大於新區間的end
        // 3. 新區間和當前區間衝突
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {
            if (interval[1] < start) {
                res.add(interval);
            } else if (interval[0] > end) {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
