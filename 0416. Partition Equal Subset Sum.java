// Medium
// DP
// Time:O(n * target), Space:O(target)
// https://leetcode.cn/problems/partition-equal-subset-sum/

class Solution {
    // 看两个背包是否能正好填满sum/2
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            // 为了确保物品只放入一次，需要逆序遍历，每个物品只有选或是不选
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}
