// Hard
// DFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/longest-cycle-in-a-graph/

import java.util.*;

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            Map<Integer, Integer> map = new HashMap<>(); // (cur node, its depth)
            int cur = i, depth = 0;

            while (cur != -1) {
                if (map.containsKey(cur)) {
                    // find cycle: cur depth - first depth enter this node
                    res = Math.max(res, depth - map.get(cur));
                    break;
                }
                if (vis[cur]) break;

                map.put(cur, depth);
                vis[cur] = true;
                cur = edges[cur];
                depth++;
            }
        }
        return res;
    }
}
