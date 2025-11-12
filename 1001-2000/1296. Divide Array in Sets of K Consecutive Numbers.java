// Medium
// Greedy, HashMap
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/divide-array-in-sets-of-k-consecutive-numbers/

import java.util.*;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;
        
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            if (map.getOrDefault(x, 0) == 0)
                continue;
            for (int i = 0; i < k; i++) {
                if (map.getOrDefault(x + i, 0) == 0)
                    return false;
                map.put(x + i, map.get(x + i) - 1);
            }
        }
        return true;
    }
}
