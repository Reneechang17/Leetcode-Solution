// Medium
// Priority Queue
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/meeting-rooms-ii/

import java.util.*;

class Solution {
    // sort the start time, and add first end time in pq
    // for the every cur one, check if the cur start time is bigger than the prev's end time
    // if no conflict, we no need for new meeting room; if conflict, we need a new one
    public int minMeetingRooms(int[][] intervals) {
        // basecase
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]); // initialize the pq and add the first end time

        for (int i = 1; i < intervals.length; i++) {
            // if the cur start time > prev's end time -> no conflict
            if (intervals[i][0] >= pq.peek()) {
                pq.poll(); // poll the prev ended meeting
            }
            // if conflict, add cur end time to pq
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
