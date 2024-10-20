// Medium
// BFS, Graph
// O(n + e)
// https://leetcode.cn/problems/graph-valid-tree/

import java.util.*;

class Solution {
    // 這題的prereq是了解樹的特質：1.連通無環的無向圖 2.對於n個節點的圖，他的邊一定是n-1
    // -> UnionFind, DFS/BFS
    // -> BFS: 先檢查邊的數量是不是n-1，再檢查是否連通（遍歷過程是否都有遍歷到）以及是否有環（遇到已經訪問即有環）
    public boolean validTree(int n, int[][] edges) {
        // 檢查邊的數量是不是n-1
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 每條邊數組包含[u,v], 表示節點u和節點v之間有一條無向邊
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        vis[0] = true;

        // 存儲節點的父節點:如果訪問到的鄰居節點已經被訪問
        // 並且這個鄰居節點不是從當前節點的父節點訪問過來的，才說明有環
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        while (!que.isEmpty()) {
            int node = que.poll();
            for (int neighbor : graph.get(node)) {
                 // 如果鄰居沒有被訪問過
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    parent[neighbor] = node; // 設置當前節點為鄰居的父節點
                    que.offer(neighbor);
                } else if (parent[node] != neighbor) {
                    // 如果鄰居節點已經訪問過，並且不是當前節點的父節點
                    return false; // 有環
                }
            }
        }

        // 檢查所有節點都有被訪問過
        for (boolean v : vis) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
