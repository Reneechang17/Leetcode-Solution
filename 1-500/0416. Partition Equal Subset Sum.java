// Medium
// DP
// Time:O(n*target),Space:O(target)
// https://leetcode.cn/problems/partition-equal-subset-sum/

class Solution {
    // check if bag can fill sum/2
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // iterate from end to begin to make each item only put one time
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}
