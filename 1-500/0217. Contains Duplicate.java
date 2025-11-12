// Easy
// Hash Table
// https://leetcode.cn/problems/contains-duplicate/

import java.util.*;

class Solution {
    // Hash Table
    // Time:O(n), Space:O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}

class Solution2 {
    // Space optimization
    // Time:O(nlogn), Space:O(1)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
