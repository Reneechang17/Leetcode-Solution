// Easy
// Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/two-sum/

import java.util.*;

class Solution {
    // Like if nums=[2, 3, 4] target = 7
    // for 2, find if there have 5 to match,
    // for 3, find if there have 4 to match...
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // basecase
        if (nums == null || nums.length == 0) return res;

        // Map store the number and its index
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
