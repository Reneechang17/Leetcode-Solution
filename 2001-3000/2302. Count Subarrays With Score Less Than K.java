// Hard
// Slding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/

class Solution {
    // count the number of subarrays with ending at right
    public long countSubarrays(int[] nums, long k) {
        long ans = 0, sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k && left <= right) {
                sum -= nums[left];
                left++;
            }

            ans += (right - left + 1);
        }
        return ans;
    }
}
