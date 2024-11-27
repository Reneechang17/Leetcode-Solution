// Medium
// Prefix
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/product-of-array-except-self/

class Solution {
    // calculate the left side sum and right side sum 
    // calculate the prefix sum and suffix sum
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = 1; // no element on the left of nums[0]

        for (int i = 1; i < n; i++) {
            // prefixSum of cur element = prefixSum of prev element * prev element
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            // multiply the cur suffix with the calculated prefix to get the product except itself
            prefix[i] = prefix[i] * suffix;
            // update suffix, prepare for the next element
            suffix *= nums[i];
        }
        return prefix;
    }
}
