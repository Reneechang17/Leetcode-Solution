// Medium
// BFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/jump-game-vii/

// Can we jump from 0 to n-1?
// Jump + check reachable -> BFS (for shortest path, if we find it, it would be the best path)

import java.util.*;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1')
            return false;

        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int farthest = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            // check [cur + minJump, cur + maxJump] 
            int start = Math.max(cur + minJump, farthest + 1);
            int end = Math.min(cur + maxJump, n - 1);

            for (int next = start; next <= end; next++) {
                if (s.charAt(next) == '0' && !vis[next]) {
                    if (next == n - 1)
                        return true;
                    que.offer(next);
                    vis[next] = true;
                }
            }
            farthest = Math.max(farthest, cur + maxJump);
        }
        return false;
    }
}
