// Easy
// Tree, BFS
// O(n)
// https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    Queue<TreeNode> que = new LinkedList<>();
    que.offer(root);
    int depth = 0;

    while (!que.isEmpty()) {
      int len = que.size();
      depth++;

      TreeNode curNode = null;
      for (int i = 0; i < len; i++) {
        curNode = que.poll();

        if (curNode.left == null && curNode.right == null)
          return depth;

        if (curNode.left != null)
          que.offer(curNode.left);
        if (curNode.right != null)
          que.offer(curNode.right);
      }
    }
    return depth;
  }
}

/**
 * 這題找二叉樹的最小深度，即當找到第一個葉子節點時，就返回depth
 * 需要check該節點同時沒有左孩子和右孩子，沒有的話直接返回
 * 
 * 有的話就繼續遍歷
 **/