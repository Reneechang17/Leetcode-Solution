// Medium
// DP
// O(n)
// https://leetcode.cn/problems/jump-game-vi/

import java.util.*;

class Solution {
    // 从数组第一个元素跳到最后一个元素，并且最大会跳跃过程中经过的元素和
    // 可以从i跳到i+j，其中1<=j<=k，k是允许的最大步长
    // 为了避免每次更新dp[i]时都需要遍历前k个元素，可以用双向队列来获取前k步最大得分
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        // 保存dp的索引，队首始终保持为窗口内最大值的索引
        Deque<Integer> deq = new ArrayDeque<>();
        deq.add(0);

        for (int i = 1; i < n; i++) {
            // 当前dp[i]为nums[i] + 目前队首元素的dp值
            dp[i] = nums[i] + dp[deq.peekFirst()];

            // 移除所有小于当前dp[i]的元素，因为他们没用了
            while (!deq.isEmpty() && dp[i] >= dp[deq.peekLast()]) {
                deq.pollLast();
            }

            // 添加当前索引到队列
            deq.add(i);

            // 如果队首的元素超出了窗口范围k，移除队首
            if (deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }
        }
        return dp[n - 1];
    }
}
