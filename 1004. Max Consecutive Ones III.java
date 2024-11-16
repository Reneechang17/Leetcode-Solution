// Medium
// Sliding Window
// O(n)
// https://leetcode.cn/problems/max-consecutive-ones-iii/

class Solution {
    // sliding window
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLength = 0;
        int zero = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zero++;
            }

            while (zero > k) {
                // shrink the window
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            // update the maxLength
            maxLength = Math.max(maxLength, right - left + 1);

            // expand the window
            right++;
        }
        return maxLength;
    }
}
