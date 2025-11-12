// Medium
// Greedy
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/rabbits-in-forest/

import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : answers) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
