// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/find-indices-with-index-and-value-difference-ii/

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;

        for (int j = indexDifference; j < n; j++) {
            // i's range is [0, j - indexDifference]
            int i = j - indexDifference;

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }

            if (Math.abs(nums[j] - nums[minIndex]) >= valueDifference) {
                return new int[] { minIndex, j };
            }

            if (Math.abs(nums[j] - nums[maxIndex]) >= valueDifference) {
                return new int[] { maxIndex, j };
            }
        }
        return new int[] { -1, -1 };
    }
}
