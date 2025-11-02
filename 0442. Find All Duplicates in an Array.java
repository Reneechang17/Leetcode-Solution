// Medium
// Array, Hash Table
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/find-all-duplicates-in-an-array/

import java.util.*;

// Try to modify in place

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int x : nums) {
            int index = Math.abs(x) - 1;

            // we can mark as negative means we visited already.
            if (nums[index] < 0) {
                res.add(Math.abs(x));
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }
}
