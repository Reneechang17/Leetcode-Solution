// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/contains-duplicate-ii/

import java.util.*;

class Solution {
    // we can use map to store the num and its index
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // if the map has cur num, we can calculate their distance
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // otherwise, we put the cur and its index to map
            map.put(nums[i], i);
        }
        return false;
    }
}
