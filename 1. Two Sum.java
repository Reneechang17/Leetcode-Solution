// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/two-sum/

import java.util.*;

class Solution {
    // we can use map to store the num and its index
    // then we iterate the nums, our goal is to find the another part which add the cur
    // their sum will be target
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        // basecase
        if (nums.length == 0 || nums == null) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            // means there have a num which add cur and be target
            if (map.containsKey(goal)) {
                res[0] = map.get(goal); // put the index of goal to res
                res[1] = i; // put the cur index to res as well
                break;
            }
            // if another part not in the map, we can just put the cur num and its index to map
            // for later match
            map.put(nums[i], i);
        }
        return res;
    }
}
