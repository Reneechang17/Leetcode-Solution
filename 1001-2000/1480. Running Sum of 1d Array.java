// Easy
// PrefixSum
// https://leetcode.cn/problems/running-sum-of-1d-array/

class Solution {
    // Straight: PrefixSum 
    // Time:O(n), Space:O(n)
    public int[] runningSum(int[] nums) {
        // prefixSum[i] = prefixSum[i-1] + nums[i]
        int n = nums.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0]; // init

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }
}

class Solution2 {
    // Save space
    // Time:O(n), Space:O(1)
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
