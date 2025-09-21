// Easy
// HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/number-of-good-pairs/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int x : nums) {
            // It could be form as the good pair with prev appear one(s)
            cnt += map.getOrDefault(x, 0);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return cnt;
    }
}
