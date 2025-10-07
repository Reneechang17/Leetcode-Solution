// Medium
// TreeSet, Map, Greedy
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/avoid-flood-in-the-city

import java.util.*;

// We want to find the next rain day for the same lake.

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>(); // full lake -> days
        TreeSet<Integer> dry = new TreeSet<>();
        int[] ans = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dry.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                ans[i] = -1;

                if (map.containsKey(lake)) {
                    Integer sunnyDay = dry.ceiling(map.get(lake));

                    if (sunnyDay == null) {
                        // which means there is no sunny days ->flood
                        return new int[0];
                    }
                    ans[sunnyDay] = lake;
                    dry.remove(sunnyDay);
                }
                map.put(lake, i);
            }
        }
        return ans;
    }
}
