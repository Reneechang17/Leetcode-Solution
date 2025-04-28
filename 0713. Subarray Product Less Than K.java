// Medium
// Slding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/subarray-product-less-than-k/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // count the number of subarrays with ending at right
        if (k <= 1) return 0;
        int product = 1, left = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
