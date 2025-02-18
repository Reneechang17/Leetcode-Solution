// Medium
// BFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/

import java.util.*;
class Solution {
  public int maxLevelSum(TreeNode root) {
      if (root == null) return 0;
      Queue<TreeNode> que = new LinkedList<>();
      que.offer(root);
      int maxSum = Integer.MIN_VALUE, minLevel = 0, level = 1;
      while (!que.isEmpty()) {
          int n = que.size();
          int levelSum = 0;
          for (int i = 0; i < n; i++) {
              TreeNode node = que.poll();
              levelSum += node.val;
              if (node.left != null) que.offer(node.left);
              if (node.right != null) que.offer(node.right);
          }
          if (levelSum > maxSum) {
              maxSum = levelSum;
              minLevel = level;
          }
          level++;
      }
      return minLevel;
  }
}
