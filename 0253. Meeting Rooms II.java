// Medium
// Priority Queue
// Time:O(nlogn), Space:O(n)->if all conflict
// https://leetcode.cn/problems/meeting-rooms-ii/

import java.util.*;

class Solution {
    // Use Priority Queue to track ongoing meetings and its end time
    // Sort by start time, and add first meeting's end time
    // Each time we go through the meetings, compare the cur start time and prev end time(pq.peek())
    // If no conflict, reuse room; if conflict, add cur end time to que to account for new room
    public int minMeetingRooms(int[][] intervals) {
        // basecase
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // if cur start after or when the earliest meeting end
            // no conflict-> reuse the room by removing the earliest ended meeting
            // 没有冲突，会把之前的meeting移除，加入当前的
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            // add the cur end time to the que 
            pq.offer(intervals[i][1]);
        }
        // the size of que represents the max number of rooms needed
        return pq.size();
    }
}
