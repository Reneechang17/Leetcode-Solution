// Medium
// Two Pointers, Sorting
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/3sum-closest/

import java.util.*;
class Solution {
    // Sort arr and use two pointers to find the closest sum
    // Use a variable to check it
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
