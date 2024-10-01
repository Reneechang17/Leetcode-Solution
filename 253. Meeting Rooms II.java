// Medium
// Priority Queue
// O(nlogn)
// https://leetcode.cn/problems/meeting-rooms-ii/

import java.util.*;

class Solution {
  public int minMeetingRooms(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
          return 0;
      }

      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      PriorityQueue<Integer> heap = new PriorityQueue<>();

      heap.add(intervals[0][1]); // 把第一個會議的結束時間放入最小堆中

      // 遍歷剩餘的會議
      for (int i = 1; i < intervals.length; i++) {
          // 如果當前時間的開始時間大於等於堆中最早結束的會議，則不需要新的會議室，因為時間不衝突
          if (intervals[i][0] >= heap.peek()) {
              heap.poll(); // 移除已經結束的會議
          }
          // 如果時間衝突，則將當前會議的結束時間放入推中，需要新開會議室
          heap.add(intervals[i][1]);
      }
      return heap.size();
  }
}
