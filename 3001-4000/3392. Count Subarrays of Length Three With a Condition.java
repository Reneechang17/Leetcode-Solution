// Easy
// Iteration
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/count-subarrays-of-length-three-with-a-condition/

class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ans++;
            }
        }
        return ans;
    }
}
