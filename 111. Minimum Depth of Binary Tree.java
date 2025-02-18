// Easy
// BFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/minimum-depth-of-binary-tree/

import java.util.*;
class Solution {
  // If reach leaf node, return depth
  public int minDepth(TreeNode root) {
      if (root == null) return 0;
      Queue<TreeNode> que = new LinkedList<>();
      que.offer(root);
      int depth = 0;
      while (!que.isEmpty()) {
          int n = que.size();
          depth++;
          for (int i = 0; i < n; i++) {
              TreeNode tmp = que.poll();
              if (tmp.left == null && tmp.right == null) return depth;
              if (tmp.left != null) que.offer(tmp.left);
              if (tmp.right != null) que.offer(tmp.right);
          }
      }
      return depth;
  }
}
