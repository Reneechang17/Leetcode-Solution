// Medium
// Map
// Time:O(n*d), Space:O(n)
// https://leetcode.cn/problems/count-nice-pairs-in-an-array/

import java.util.*;

class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        int MOD = 1_000_000_007;

        for (int x : nums) {
            int diff = x - reverse(x);

            cnt += map.getOrDefault(diff, 0);
            cnt %= MOD;

            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return (int) cnt;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}
