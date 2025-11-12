// Hard
// In-place Hashing
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/first-missing-positive/

// To reach O(1) space, we need to do in original arr.
// For this question, we actually need to check if it appears before, so need a way to mark if it appears.
// We can use in-place Hashing -> serve index as key, and put it's value in the "correct" place.

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // nums[i] should put in nums[nums[i] - 1]
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        // Find the first place with wrong number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1; // The case we actually perfectly match with all numbers, like [1,2,3...n]
    }
}
