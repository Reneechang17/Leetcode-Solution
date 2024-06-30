// Medium
// Tree, BFS
// O(n)
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public Node connect(Node root) {
      Queue<Node> que = new LinkedList<>();
      if (root != null) que.add(root);

      while (!que.isEmpty()) {
          int len = que.size();
          Node curNode = null;
          Node preNode = null;

          for (int i = 0; i < len; i++) {
              if (i == 0) {
                  preNode = que.poll();
                  curNode = preNode;
              } else {
                  curNode = que.poll();
                  preNode.next = curNode;
                  preNode = preNode.next;
              }

              if (curNode.left != null) que.add(curNode.left);
              if (curNode.right != null) que.add(curNode.right);
          }
          preNode.next = null;
      }
      return root;
  }
}

/**
 * 這題和前一題116類似，但不同的是處理的是一個普通的二叉樹，其節點數是任意的，子節點的數量也不受限制（0/1/2）
 * 由於樹結構可能不完整，處理next指針時需要檢查當前節點的next指針，以確定當前節點的子節點的next指針應該指向哪裡
 * 通過追蹤前一個節點preNode並在適當設置next指針，以及確定每一層最後一個節點指向null
 **/