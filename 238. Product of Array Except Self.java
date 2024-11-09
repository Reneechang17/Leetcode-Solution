// Medium
// Prefix
// O(n)
// https://leetcode.cn/problems/product-of-array-except-self/

class Solution {
    // calculate the left side sum and right side sum 
    // calculate the prefix sum and suffix sum
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = 1; // there is no element on the left of nums[0]
        for (int i = 1; i < n; i++) {
            // 当前元素的前缀积等于前一个元素的前缀积乘以前一个元素的值
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int suffix = 1; // 初始化后缀积
        for (int i = n - 1; i >= 0; i--) {
            // 将当前的后缀积乘上已经计算的前缀积，得到除自身以外的乘积
            prefix[i] = prefix[i] * suffix;
            // 更新后缀积，准备计算下一个元素的乘积
            suffix *= nums[i];
        }
        return prefix;
    }
}
