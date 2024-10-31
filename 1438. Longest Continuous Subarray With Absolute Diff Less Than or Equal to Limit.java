// Medium
// Sliding Window, Deque
// O(n)
// https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

import java.util.*;

class Solution {
  // Sliding Window + Deque
  public int longestSubarray(int[] nums, int limit) {
    // 存储当前窗口的最大值和最小值
      Deque<Integer> maxDeq = new LinkedList<>(); 
      Deque<Integer> minDeq = new LinkedList<>();

      int left = 0, maxLen = 0;
      for (int right = 0; right < nums.length; right++) {
        // 确保maxDeq中的元素从大到小排列
          while (!maxDeq.isEmpty() && nums[maxDeq.peekLast()] <= nums[right]) {
              maxDeq.pollLast();  // 移除Deq中比当前元素小的元素
          }
          maxDeq.addLast(right); // 加入当前元素所以

          // 确保minDeq中的元素从小到大排列
          while (!minDeq.isEmpty() && nums[minDeq.peekLast()] >= nums[right]) {
              minDeq.pollLast();
          }
          minDeq.addLast(right);

          while (nums[maxDeq.peekFirst()] - nums[minDeq.peekFirst()] > limit) {
            left++;
              
            // 如果最大值/最小值的索引小于新的左边界，就移除
              if (maxDeq.peekFirst() < left) {
                  maxDeq.pollFirst();
              }

              if (minDeq.peekFirst() < left) {
                  minDeq.pollFirst();
              }
          }
          maxLen = Math.max(maxLen, right - left + 1);
      }
      return maxLen;
  }
}
