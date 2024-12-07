// Medium
// Two Pointers, Sorting
// Time:O(n^2), Space:O(n^2)
// https://leetcode.cn/problems/3sum/

import java.util.*;

class Solution {
    // two pointers + sorting, if the first element in array is bigger than one -> return
    // use fixed pointer to iterate the nums, and use two pointers to adjust the element
    // if the sum of three pointers too big -> adjust right pointer, otherwise adjust left
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // since the array has sort, if the start one is bigger than 0
            // the 3sum will not be 0
            if (nums[i] > 0) return res;
            // check duplicate for i pointer
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // check duplicate for left and right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res; 
    }
}
