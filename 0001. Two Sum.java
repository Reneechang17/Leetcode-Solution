// Easy
// Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/two-sum/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;
        
        // key: number, value: index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[0] = i;
                res[1] = map.get(tmp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
