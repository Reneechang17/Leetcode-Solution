// Medium
// XOR, Prefix sum
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/

import java.util.*;

class Solution {
    // Similar to 560, using HashMap and Prefix sum
    public long beautifulSubarrays(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); // 异或为0时，默认已经存在一个子数组
        long res = 0, xor = 0;
        for (int num : nums) {
            xor ^= num;
            Long c = map.getOrDefault(xor, 0L);
            res += c;
            map.put(xor, c + 1);
        }
        return res;
    }
}
