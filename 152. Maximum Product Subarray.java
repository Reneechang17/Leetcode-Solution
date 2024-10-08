// Medium
// Array
// O(n)
// https://leetcode.cn/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], curMax = nums[0], curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // 如果當前是負數，也有可能負數*負數成為一個更大的數
            // 那curMin和curMax要互換一下
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            // 計算當前元素的最大值和最小值
            curMax = Math.max(num, curMax * num);
            curMin = Math.min(num, curMin * num);

            // 更新全局最大值
            max = Math.max(max, curMax);
        }
        return max;
    }
}
