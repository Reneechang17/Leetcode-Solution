// Medium
// Prefix, Map
// Time:O(n), Space:O(k)
// https://leetcode.cn/problems/subarray-sums-divisible-by-k/

import java.util.*;

// If two remainder from prefixSum % k are same, the subarrays between them could be divided by k.

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, res = 0;
        
        for (int x : nums) {
            sum += x;

            int remainder = ((sum % k) + k) % k;

            res += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }
}
