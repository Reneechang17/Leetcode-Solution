// Medium
// Two Pointers, Sorting
// Time:O(n^2), Space:O(1), Sort->logn
// https://leetcode.cn/problems/3sum/

import java.util.*;

class Solution {
    // First sort the arr, if first element is bigger than one -> return
    // Use three pointer to do it, one is fixed pointer to iterate the arr
    //   and another two pointers to adjust element on i + 1 and last element
    //   if sum of three pointers too big -> adjust right pointer, otherwise adjust left
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // check duplicate
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // check duplicate for left and right
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
