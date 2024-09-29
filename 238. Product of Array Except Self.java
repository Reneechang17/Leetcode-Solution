// Medium
// Prefix
// O(n)
// https://leetcode.cn/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        // 1. 計算前綴和
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1]; 
        }

        // 2. 計算後綴和
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }
        return prefix;
    }
}

/**
 * 除自身以外數組的乘積：給定一個數組，返回一個新的數組，新數組的每個元素是原數組中除了自身以外所有元素的乘積
 * 
 * 通過左右兩個方向的前綴積計算每個位置的結果
 * 一次左到右計算前綴積，一次右到左計算後綴積
 * **/