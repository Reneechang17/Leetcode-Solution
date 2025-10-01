// Medium
// Array, Map, Math
// Time:O(n^2), Space:O(n)
// https://leetcode.cn/problems/number-of-boomerangs/

// i to j = i to k (j/k are different)
// For each i, if there are n points, which distance are all the same d.
// For first point as j, we have n' choices; for second point as k, we have n - 1' choices.
// Totally we have n * (n - 1).

import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (int cnt : map.values()) {
                res += cnt * (cnt - 1);
            }
        }
        return res;
    }

    private int getDist(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
