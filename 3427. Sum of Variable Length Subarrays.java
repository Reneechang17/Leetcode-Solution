// Easy
// Array, PrefixSum
// https://leetcode.cn/problems/sum-of-variable-length-subarrays/

class Solution {
    // Time:O(n^2), Space:O(1)
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);

            // calculate the sum of nums[start...i]
            int subarraySum = 0;
            for (int j = start; j <= i; j++) {
                subarraySum += nums[j];
            }

            total += subarraySum;
        }
        return total;
    }
}

// but when n growing, prefixSum would be more efficiency
class Solution2 {
    // Time:O(n), Space:O(n)
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            total += prefixSum[i + 1] - prefixSum[start];
        }
        return total;
    }
}
