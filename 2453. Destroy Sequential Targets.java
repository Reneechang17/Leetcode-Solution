// Medium
// Greedy (probably only for me)
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/destroy-sequential-targets/

// I can't make sense to the problem statement at first tbh.

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> min = new HashMap<>();

        for (int x : nums) {
            int rem = x % space;
            cnt.put(rem, cnt.getOrDefault(rem, 0) + 1);
            min.put(rem, Math.min(min.getOrDefault(rem, x), x));
        }

        int maxCnt = 0, res = Integer.MAX_VALUE;

        for (int rem : cnt.keySet()) {
            int c = cnt.get(rem);
            int seed = min.get(rem);

            if (c > maxCnt || (c == maxCnt && seed < res)) {
                maxCnt = c;
                res = seed;
            }
        }
        return res;
    }
}
