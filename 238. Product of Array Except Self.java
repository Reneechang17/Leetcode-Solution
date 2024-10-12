// Medium
// Prefix
// O(n)
// https://leetcode.cn/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 通過左右兩個方向的前綴和計算累加每個位置的res
        int n = nums.length;
        int[] prefix = new int[n];

        // 一次左到右的前綴積
        prefix[0] = 1; // 沒有元素在nums[0]的左邊
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // 一次右到左的後綴積
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }
        return prefix;
    }
}
