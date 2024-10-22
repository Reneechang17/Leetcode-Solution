// Medium
// DP
// O(n)
// Similar: 256
// https://leetcode.cn/problems/house-robber-ii/

class Solution {
    // 最後一個和第一個挨著，不同同時搶頭和尾 -> 只能考慮搶頭不搶尾 or 搶尾不搶頭
    // 可以用dp，因為當前的選擇是根據前一個狀態分析出來的
    // 當前dp可以是不搶當前的（即狀態為prev沿用） or 搶當前的（prev2 + nums[i]）中較大的
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 搶頭不搶尾/搶尾不搶頭
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }

    private int helper(int[] nums, int start, int end) {
        int prev2 = 0, prev = 0, cur = 0;
        for (int i = start; i < end; i++) {
            prev = cur;
            cur = Math.max(prev, prev2 + nums[i]);
            prev2 = prev;
        }
        return cur;
    }
}
