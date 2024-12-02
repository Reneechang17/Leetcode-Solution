// Medium
// BFS, Graph
// Time:O(V+E),Space:O(V+E)
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
  // If node is null, return null; clone the start node and store in Map
  // For each node, clone neighbors if not already cloned and add to queue
  // Return the cloned start node.
  public Node cloneGraph(Node node) {
      // basecase
      if (node == null) return null;

      // map to store the node has been visited
      Map<Node, Node> vis = new HashMap<>();

      // clone the start node and add it map
      Node startNode = new Node(node.val, new ArrayList<>());
      vis.put(node, startNode);

      Queue<Node> que = new LinkedList<>();
      que.offer(node);
      while (!que.isEmpty()) {
          Node cur = que.poll();
          // iterate the neighbor of the cur node
          for (Node neighbor : cur.neighbors) {
              if(!vis.containsKey(neighbor)) {
                  Node neighborClone = new Node(neighbor.val, new ArrayList<>());
                  vis.put(neighbor, neighborClone);
                  que.offer(neighbor);
              }
              // add the clone neighbor to cur node's neighbor list
              vis.get(cur).neighbors.add(vis.get(neighbor));
          }
      }
      return startNode;
  }
}
