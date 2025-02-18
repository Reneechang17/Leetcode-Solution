// Hard 
// Deque
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/sliding-window-maximum/

import java.util.*;

class Solution {
    // Use Deque to maintain indices of elements in cur sliding window
    //   - the deq keeps elements in decreasing order of their values
    // For each iteration: 1. remove indices of elements that out of window
    //   - 2. remove indices of smaller elements from deq to maintain decreasing order
    //   - 3. add the cur index to deq
    //   - 4. once the window is fully formed, record the max value(at the front of the deq)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // basecase
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        // result arr to store the max value for each window
        int[] res = new int[n - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.peekFirst() < i - k + 1) {
                deq.pollFirst();
            }
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }
            deq.offer(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deq.peekFirst()];
            }
        }
        return res;
    }
}
