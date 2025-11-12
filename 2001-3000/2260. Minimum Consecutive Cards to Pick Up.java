// Medium
// Map
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/minimum-consecutive-cards-to-pick-up/

import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                // +1 for include
                int len = i - map.get(cards[i]) + 1;
                minLen = Math.min(minLen, len);
            }
            map.put(cards[i], i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}