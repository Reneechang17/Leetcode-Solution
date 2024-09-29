// Medium
// BFS, Graph
// O(N+M)
// https://leetcode.cn/problems/clone-graph/

import java.util.*;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
      
    // 標記已經遍歷過的節點（表示已經克隆了）
      Map<Node, Node> vis = new HashMap<>();

      Node cloneNode = new Node(node.val, new ArrayList<>());
      vis.put(node, cloneNode);

      Queue<Node> que = new LinkedList<>();
      que.offer(node);

      // 用BFS遍歷圖，從起點節點開始逐層遍歷所有節點
      while (!que.isEmpty()) {
          Node cur = que.poll();

          // 檢查當前節點的鄰居節點：如果鄰居節點還沒有被克隆，則克隆它，並將其加入vis和隊列中
          for (Node neighbor : cur.neighbors) {
              if (!vis.containsKey(neighbor)) {
                  Node neighborClone = new Node(neighbor.val, new ArrayList<>());
                  vis.put(neighbor, neighborClone);
                  que.offer(neighbor);
              }
              // 將克隆的鄰居節點加入當前克隆節點的鄰居列表
              vis.get(cur).neighbors.add(vis.get(neighbor));
          }
      }
      return cloneNode;
  }
}