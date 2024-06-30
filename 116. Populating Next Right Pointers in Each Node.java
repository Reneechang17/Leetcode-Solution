// Medium
// Tree, BFS
// O(n)
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public Node connect(Node root) {
      Queue<Node> que = new LinkedList<>();
      if (root != null) que.add(root);

      while (que.size() != 0) {
          int len = que.size();

          Node curNode = que.poll();
          if (curNode.left != null) que.add(curNode.left);
          if (curNode.right != null)
            que.add(curNode.right);
          
          // 操作每一層
          for (int i = 1; i < len; i++) {
              Node nextNode = que.poll();
              if (nextNode.left != null) que.add(nextNode.left);
              if (nextNode.right != null) que.add(nextNode.right);

              curNode.next = nextNode;
              curNode = nextNode;
          }
      }
      return root;
  }
}

/**
 * 這題是給每一個節點加上他的next指針，指向節點的右側節點，如果右側沒有節點，就指向null
 * 可以看一下example的圖比較好理解
 * 
 * 可以用層序遍歷+Queue來操作
 * 對於每一層（注意i要從1開始，因為i = 0 就是curNode，已經處理掉了）
 * 使用que.poll()取出下一個節點（即nextNode），並將當前（curNode）的next指向nextNode
 * 再把curNode更新為nextNode作下一輪迭代
 * 
 * Note：這題處理的是一個完美二叉樹（每個節點都有0個or2個子節點，且葉子節點都在同一層）
 **/