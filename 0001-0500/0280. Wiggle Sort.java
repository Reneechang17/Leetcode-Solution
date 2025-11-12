// Medium
// Array, Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/wiggle-sort/

class Solution {
    // For every odd index -> nums[i] <= nums[i+1]
    // For every even index -> nums[i] >= nums[i+1]
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 != 0 && nums[i] < nums[i + 1])) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }
}
