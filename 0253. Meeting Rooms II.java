// Medium
// Priority Queue
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/meeting-rooms-ii/

// Basic idea: If no conflict, we can resue the meeting room; if conflict, need to add one.

import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // basecase 
        // if (intervals == null || intervals.length == 0) return 0;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // pq will include the max meeting rooms we need.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]); // init with first end time

        for (int i = 1; i < intervals.length; i++) {
            // check conflict, if no, pop out the prev meeting room
            // Cur' start >= prev' end 
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            // or we add the cur to pq -> need a new room
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}
