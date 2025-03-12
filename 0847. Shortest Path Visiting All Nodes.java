// Hard
// Bitmask, BFS
// Time:O(n^2 * 2^n), Space:O(n * 2^n)
// https://leetcode.cn/problems/shortest-path-visiting-all-nodes/

import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, ans = 0;
        Queue<int[]> que = new LinkedList<>();

        // vis[i][j]表示在状态j下是否已经访问过i
        boolean[][] vis = new boolean[n][1 << n];

        // 初始化：从每个节点出发，访问当前节点
        for (int i = 0; i < n; i++) {
            que.offer(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true; // 当前节点已经访问
        }

        // BFS
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curNode = cur[0], mask = cur[1], step = cur[2];

            // 如果所有节点都已经被访问，返回当前步数
            if (mask == (1 << n) - 1) {
                ans = step;
                break;
            }

            // search adjacency node
            for (int next : graph[curNode]) {
                // 更新mask，把next设置为1，访问过
                int nextMask = mask | (1 << next);
                // 如果这个状态还没有被访问过，则加入que，并且更新vis
                if (!vis[next][nextMask]) {
                    que.offer(new int[] {next, nextMask, step + 1});
                    vis[next][nextMask] = true;
                }
            }
        }
        return ans;
    }
}

/**
 * 用bitmask来表示已经访问过的节点，1表示访问过，0表示没有访问
 * 用BFS来遍历图，状态表示的是(当前节点，已经访问的节点集合，步数)，找最短路径
 * vis[i][mask]标记在访问节点i时，节点集合mask是否已经访问过，避免重复访问
 */
