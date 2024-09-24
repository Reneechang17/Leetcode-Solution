// Medium
// DFS, Graph
// O(n + e)
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

import java.util.*;

class Solution {
  public int countComponents(int n, int[][] edges) {  
      List<List<Integer>> graph = new ArrayList<>();
      boolean[] visited = new boolean[n];

      // 構建圖
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }

      // 構建圖的鄰接表，edge是一個二維數組，其中每個元素是一個長度為2的數組，表示一條無向邊
      // 比如edges[i] = [a, b]表示節點a和節點b之間有一條無向邊
      for (int[] edge: edges) {
          graph.get(edge[0]).add(edge[1]); // 將節點b加入節點a的鄰接表中，表示節點 edge[0]與節點 edge[1] 有邊連接
          graph.get(edge[1]).add(edge[0]); // 將節點a加入節點b的鄰接表中，節點 edge[1] 與節點 edge[0] 也有連接
      }

      int count = 0;

      for (int i = 0; i < n; i++) {
          if(!visited[i]) {
              count++;
              dfs(i, graph, visited); // 從未訪問過的節點開始DFS
          }
      }
      return count;
  }

  private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
      visited[node]= true;
      for (int neighbor : graph.get(node)) {
          if (!visited[neighbor]) {
              dfs(neighbor, graph, visited);
          }
      }
  }
}

/**
 * 無向圖中的連通分量數：在給定的無向圖中，找到連通分量的數量。連通分量指圖中所有節點能夠通過某個路徑互相連通的部分
 * 
 * 思路：我的想法是通過線性檢查每一條邊，將連在一起的節點標記為同一組，這個做法類似於圖論中的合併操作 => 等價於並查集
 * 這題有幾種做法：DFS, BFS,和並查集，這裡用DFS來遍歷圖中的每一個節點，找到所有互相連通的節點並標記它們屬於同一個連通分量
 * 沒有訪問過的節點可以做新的搜索，找到所有與它連通的節點
 **/