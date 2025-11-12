// Medium
// DFS, Backtracking
// Time:O(k^n), Space:O(n+k)
// https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/

import java.util.Arrays;

class Solution {
    private int[] nums;
    private int[] subsetSums;
    private int targetSum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        targetSum = sum / k;
        subsetSums = new int[k];
        // use dfs to check subset element
        // start from bigger elements to find out the illegal subset
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(nums.length - 1);
    }
    private boolean dfs(int i) {
        if (i < 0) {
            for (int sum : subsetSums) {
                if (sum != targetSum) {
                    return false;
                }
            }
            return true;
        }
        int curNum = nums[i];
        for (int j = 0; j < subsetSums.length; j++) {
            // check duplicate
            if (j > 0 && subsetSums[j] == subsetSums[j - 1]) {
                continue;
            }
            // if the sum of the subset is smaller than the target sum
            // we can add the current number to the subset
            if (subsetSums[j] + curNum <= targetSum) {
                subsetSums[j] += curNum;
                // dfs to next element
                if (dfs(i - 1)) return true;
                subsetSums[j] -= curNum; // backtracking
            }
        }
        return false;
    }
}
