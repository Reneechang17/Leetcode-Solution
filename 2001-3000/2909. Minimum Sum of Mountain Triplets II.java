// Medium
// Array
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/

// Pretty similar to 2874, but this question find the smallest one.

class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;

        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;
        for (int j = 1; j < n; j++) {
            leftMin[j] = Math.min(leftMin[j - 1], nums[j - 1]);
        }

        int[] rightMin = new int[n];
        rightMin[n - 1] = Integer.MAX_VALUE;
        for (int j = n - 2; j >= 0; j--) {
            rightMin[j] = Math.min(rightMin[j + 1], nums[j + 1]);
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 1; j < n - 1; j++) {
            if (leftMin[j] < nums[j] && rightMin[j] < nums[j]) {
                minSum = Math.min(minSum, leftMin[j] + nums[j] + rightMin[j]);
            }
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
