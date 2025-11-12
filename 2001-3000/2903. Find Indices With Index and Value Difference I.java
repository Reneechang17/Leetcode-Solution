// Easy
// Array
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + indexDifference; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
