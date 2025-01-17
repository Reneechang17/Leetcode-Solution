// Easy
// Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/contains-duplicate-ii/

import java.util.*;
class Solution {
    // Use a HashMap to store the num and its index
    // Check if the same number appears within the distance k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}