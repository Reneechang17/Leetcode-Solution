// Medium
// Prefix, Array
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/

// Actually I think my idea is pretty much straightforward...
// Because the subarray is actually the diff of two prefix(es), so we can find the max and min 
// of prefix sum which can very easy to find the max absolute sum of any subarray.

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int pre = 0, max = 0, min = 0;

        for (int i = 0; i < n; i++) {
            pre += nums[i];
            max = Math.max(max, pre);
            min = Math.min(min, pre);
        }
        return max - min;
    }
}
