// Medium
// Tree, BFS
// O(N)
// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<Integer> largestValues(TreeNode root) {
      if (root == null) {
          return new ArrayList<>();
      }

      List<Integer> res = new ArrayList<>();
      Queue<TreeNode> que = new LinkedList<>();

      que.offer(root);
      while (!que.isEmpty()) {
          int max = Integer.MIN_VALUE;
          for (int i = que.size(); i > 0; i--) {
              TreeNode node = que.poll();
              max = Math.max(max, node.val);

              if (node.left != null) que.offer(node.left);
              if (node.right != null) que.offer(node.right);
          }
          res.add(max);
      }
      return res;
  }
}

/**
 * BFS一層一層搜索，並找最大值
 * 用一個max變量在每一層不斷更新
 **/