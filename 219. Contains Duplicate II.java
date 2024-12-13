// Easy
// Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/contains-duplicate-ii/

import java.util.*;

class Solution {
    // Use a HashMap to track the most recent index of each number
    // Check if the same number appears within the allowed distance k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if number exists in map, check if difference <= k
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            // or add the cur number and its index to map
            map.put(nums[i], i);
        }
        return false;
    }
}
