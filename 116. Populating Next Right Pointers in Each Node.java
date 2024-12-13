// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/

import java.util.*;

class Solution {
  // Use BFS to connect all nodes in the same level
  // For each level, use a queue to iterate through nodes and link them with "next" pointers
  // After processing a node, add its children to the queue for the next level
  public Node connect(Node root) {
      Queue<Node> que = new LinkedList<>();
      if (root != null) que.offer(root);

      while(!que.isEmpty()) {
          int n = que.size();
          Node curNode = que.poll(); // get the first node in cur level
          if (curNode.left != null) que.offer(curNode.left);
          if (curNode.right != null) que.offer(curNode.right);
          for (int i = 1; i < n; i++) {
              Node nextNode = que.poll(); // fetch the next node in the level
              if (nextNode.left != null) que.offer(nextNode.left);
              if (nextNode.right != null) que.offer(nextNode.right);
              curNode.next = nextNode;
              curNode = nextNode;
          }
      }
      return root;
  }
}
