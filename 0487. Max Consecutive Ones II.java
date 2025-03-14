// Medium
// Sliding Window
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/max-consecutive-ones-ii/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, max = 0, zero = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zero++;
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                } 
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
