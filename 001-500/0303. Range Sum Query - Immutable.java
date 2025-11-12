// Easy
// Prefix Sum
// https://leetcode.cn/problems/range-sum-query-immutable/

class NumArray {

    private int[] prefixSum;

    // Time:O(n), Space:O(n)
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // Time:O(1), Space:O(1)
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
