// Medium
// Priority Queue
// O(nlogn)
// https://leetcode.cn/problems/meeting-rooms-ii/

import java.util.*;

class Solution {
    // sort the start time
    // for the every cur one, we need to compare the start time is bigger than the prev's end time
    // the prev we store in the queue
    // if no conflict, we no need for new meeting room; if conflict, we need a new one
    public int minMeetingRooms(int[][] intervals) {
        // base case 
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // queue to store the prev's end time
        PriorityQueue<Integer> heap = new PriorityQueue<>(); 

        heap.add(intervals[0][1]); // Initialize the heap with first meeting's end time

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll(); // poll the prev ended meeting
            }
            // if conflict, we add the cur's end time to queue
            heap.add(intervals[i][1]);
        }
        return heap.size();
    }
}
