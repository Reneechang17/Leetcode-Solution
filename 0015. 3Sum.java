// Medium
// Two Pointers, Sorting
// Time:O(n^2), Space:O(1), Sort->nlogn
// https://leetcode.cn/problems/3sum/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > 0)
                return res;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // sum equal to 0 -> add to res
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // check duplicate before moving left/right pointers
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    // move left/right pointers (plz remember)
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
