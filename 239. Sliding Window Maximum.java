// Hard 
// Deque
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/sliding-window-maximum/

import java.util.*;

class Solution {
    // 给定一个大小为k的滑动窗口，从整数数组找到每个窗口内的最大值
    // 因为要不断对窗口的左右做元素调整，可以用Deque，存储数组元素的索引，队首总是窗口内最大值的索引
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 清理队首元素，如果它已经超出滑动窗口范围
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 保持队列的单调性，从队尾移除所有小于当前元素的值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 将当前元素加入队列
            deque.offerLast(i);
            // 记录当前窗口的最大值，窗口开始填满时-> i>=k-1
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
