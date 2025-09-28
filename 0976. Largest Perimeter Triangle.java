// Easy
// Sorting, Greedy
// Time:O(n logn),Space:O(1)
// https://leetcode.cn/problems/largest-perimeter-triangle/

// The brute force way is form the every triangle and record the largest one.
// We can optimize using sorting, so that nums[i] + nums[i+1] > nums[i+2] is what we check.
// Since we want the largest one, so we can start from the longest side. (Greedy)

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
