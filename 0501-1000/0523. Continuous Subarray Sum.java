// Medium
// Map
// Time:O(n), Space:O(min(n,k))
// https://leetcode.cn/problems/continuous-subarray-sum/

import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;

            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2)
                    return true;
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
