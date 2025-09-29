// Medium
// Array
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/

// It could be [...firstLen...][...secondLen...] or [...secondLen...][...firstLen...]

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int maxSum = 0;
        
        for (int i = 0; i <= n - firstLen; i++) {
            int sum1 = 0;
            for (int k = i; k < i + firstLen; k++) {
                sum1 += nums[k];
            }

            // second in front of first
            for (int j = 0; j <= i - secondLen; j++) {
                int sum2 = 0;
                for (int k = j; k < j + secondLen; k++) {
                    sum2 += nums[k];
                }
                maxSum = Math.max(maxSum, sum1 + sum2);
            }

            // second behind first
            for (int j = i + firstLen; j <= n - secondLen; j++) {
                int sum2 = 0;
                for (int k = j; k < j + secondLen; k++) {
                    sum2 += nums[k];
                }
                maxSum = Math.max(maxSum, sum1 + sum2);
            }
        }
        return maxSum;
    }
}
