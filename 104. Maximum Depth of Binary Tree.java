// Easy
// Tree, BFS
// O(n)
// https://leetcode.com/problems/maximum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int maxDepth(TreeNode root) {
      if (root == null) return 0;

      Queue<TreeNode> que = new LinkedList<>();
      que.offer(root);
      int depth = 0;
      while (!que.isEmpty()) {
          int len = que.size();
          while (len > 0) {
              TreeNode node = que.poll();
              if (node.left != null) que.offer(node.left);
              if (node.right != null) que.offer(node.right);
              len--;
          }
          depth++;
      }
      return depth;
  }
}

/**
 * 這題找二叉樹的最大深度，最大深度為根節點到最遠葉子節點的最長路徑上的節點數
 * Note：葉子節點指的是沒有子節點的節點
 * 
 * 可以用層序遍歷，再用一個depth變量來紀錄遍歷的層數
 * 
 * 補充：這題也可以用遞歸和後序遍歷
 **/