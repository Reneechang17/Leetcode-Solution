// Easy
// String, Map
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/number-of-equivalent-domino-pairs/

import java.util.*;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int[] d : dominoes) {
            // put the smaller one first
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            String key = a + "," + b;

            cnt += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return cnt;
    }
}
