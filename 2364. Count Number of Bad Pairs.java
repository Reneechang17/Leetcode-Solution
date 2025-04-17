// Medium
// Math, Hash Map
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/count-number-of-bad-pairs/

import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        // count nums[i]-i's appear time
        Map<Integer, Integer> map = new HashMap<>();
        long goodPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            if (map.containsKey(diff)) {
                goodPairs += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        long totalPairs = (long)nums.length * (nums.length - 1) / 2;
        return totalPairs - goodPairs;
    }
}
