// Medium
// PrefixSum
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/

class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int totalSum = prefix[n - 1];
        int res = 0;

        int minMid = 1, maxMid = 1;

        for (int left = 0; left < n - 2; left++) {
            // int leftSum = prefix[left];

            minMid = Math.max(minMid, left + 1);
            while (minMid < n - 1 && prefix[minMid] < 2 * prefix[left]) {
                minMid++;
            }

            maxMid = Math.max(maxMid, minMid);
            while (maxMid < n - 1 && 2 * prefix[maxMid] <= totalSum + prefix[left]) {
                maxMid++;
            }

            if (minMid < maxMid)
                res = (res + maxMid - minMid) % MOD;
        }
        return res;
    }
}
