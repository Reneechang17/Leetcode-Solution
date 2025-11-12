// Medium
// Prefix, HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/subarray-sum-equals-k/

import java.util.*;

// TODO: Honestly I don't think I'm sensitive to prefixSum topic, may need some time to figure out
// 前缀和 - 前面的某个前缀和 = 这段区间的和 （谢谢国区lc大神的懒人包 一语道破梦中人;D）
class Solution {
    public int subarraySum(int[] nums, int k) {
        // key: prefixSum, value: appear time
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty prefixSum appear once
        int curSum = 0, res = 0;

        for (int x : nums) {
            curSum += x;
            res += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}
