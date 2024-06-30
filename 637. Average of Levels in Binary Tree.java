// Easy
// Tree, BFS
// O(N)
// Similar: 429
// https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
      List<Double> res = new ArrayList<>();
      Deque<TreeNode> que = new LinkedList<>();

      if (root == null) return res;

      que.offer(root);
      while (!que.isEmpty()) { 
          int len = que.size();
          double sum = 0.0;
          for (int i = 0; i < len; i++) {
              TreeNode node = que.poll();
              sum += node.val;
              if (node.left != null) {
                  que.add(node.left);
              }
              if (node.right != null) {
                  que.add(node.right);
              }
          }
          res.add(sum / len);
      }
      return res;
  }
}

/**
 * 這題用BFS搜索二叉樹的每一層，並計算每一層節點的平均值即可
 **/