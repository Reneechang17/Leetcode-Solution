// Medium
// Prefix, Map
// Time:O(n), Space:O(min(n,p))
// https://leetcode.cn/problems/make-sum-divisible-by-p/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;

        long total = 0;
        for (int x : nums) {
            total += x;
        }

        int remainder = (int) (total % p);
        if (remainder == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long sum = 0;
        int minLen = n;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int curMod = (int) (sum % p);

            int targetMod = ((curMod - remainder) % p + p) % p;

            if (map.containsKey(targetMod)) {
                minLen = Math.min(minLen, i - map.get(targetMod));
            }
            map.put(curMod, i);
        }
        return minLen < n ? minLen : -1;
    }
}
