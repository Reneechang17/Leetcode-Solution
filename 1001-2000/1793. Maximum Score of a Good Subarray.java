// Hard
// Greedy, Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-score-of-a-good-subarray/

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, left = k, right = k;
        int min = nums[k], max = min;

        // start from k bcz it should be included
        // and choose the bigger side to move
        while (left > 0 || right < n - 1) {
            if (left == 0) {
                right++;
            } else if (right == n - 1) {
                left--;
            } else if (nums[left - 1] >= nums[right + 1]) {
                left--;
            } else {
                right++;
            }

            min = Math.min(min, Math.min(nums[left], nums[right]));
            int curScore = min * (right - left + 1);
            max = Math.max(max, curScore);
        }
        return max;
    }
}
