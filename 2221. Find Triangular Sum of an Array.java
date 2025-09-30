// Easy
// Simulation
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/find-triangular-sum-of-an-array/

// I don't come up with any DSA to optimize this question, so I use brute force~

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--;
        }
        return nums[0];
    }
}
