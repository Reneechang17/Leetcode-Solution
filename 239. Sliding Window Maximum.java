// Hard 
// Deque
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/sliding-window-maximum/

import java.util.*;

class Solution {
    // Use deque to keep track of indices of elements in the cur sliding window
    // The deque maintain a decreasing order of the value in the cur window
    // For each iteration: 1. Remove the indices of elements that are out of window range
    // 2. Remove indices of smallers elements from the deque to maintain order
    // 3. Add the cur indix to the deque
    // 4. Once the window is fully formed, record the max value(at que's front)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of the cur sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove the smaller elements to maintain decrease order
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add the cur element's index to deque
            deque.offer(i);
            // Add the max value of cur window to res
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
