// Medium
// DFS, Graph
// O(n + e)
// https://leetcode.cn/problems/number-of-connected-components-in-an-undirected-graph/

import java.util.*;

class Solution {
    // 找圖中連通分量的數量，也就是檢查每個節點有沒有訪問過
    // 可以用DFS/BFS來遍歷圖檢查，或是用並查集
    // 這邊用相對好理解的DFS做，用一個bool數組來表示每個節點是否被訪問過
    // DFS圖中的每個節點，如果節點沒有被訪問過，說明他是新的連通分量的起點，對這個節點做DFS，並且標為已訪問
    public int countComponents(int n, int[][] edges) {
        // build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // build the adjacency list, edge[i] = [a, b]
        // add b to the list of the neighbors of a, and add a to the list of the neighbors of b
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            // 如果這個節點沒有被訪問，則說明它是一個新的連通分量
            if (!vis[i]) {
                count++;
                dfs(graph, vis, i); // dfs這個節點
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] vis, int node) {
        vis[node] = true; // mark as vis
        for (int neighbor : graph.get(node)) {
            if (!vis[neighbor]) {
                dfs(graph, vis, neighbor);
            }
        }
    }
}
