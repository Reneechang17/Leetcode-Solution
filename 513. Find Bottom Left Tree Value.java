// Medium
// Tree, BFS
// O(n)
// https://leetcode.com/problems/find-bottom-left-tree-value/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int findBottomLeftValue(TreeNode root) {
      Queue<TreeNode> que = new LinkedList<>();
      que.offer(root);
      int res = 0;

      while (!que.isEmpty()) {
          int len = que.size();
          for (int i = 0; i < len; i++) {
              TreeNode node = que.poll();
              if (i == 0) res = node.val;

              if (node.left != null) que.offer(node.left);
              if (node.right != null) que.offer(node.right);
          }
      }
      return res;
  }
}

/**
 * 找最左下角的值，也就是找樹中最後一行最左邊的值
 * 思路：用BFS一層一層找，每一層的第一個節點（i==0）就是最左邊的值
 **/