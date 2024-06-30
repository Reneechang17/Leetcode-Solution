// Medium
// Tree, BFS
// O(N)
// Similar: 637
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<>();
      Deque<Node> que = new LinkedList<>();

      if (root == null) return res;
      que.offer(root);
      while (!que.isEmpty()) {
          int len = que.size();
          List<Integer> levelItem = new ArrayList<>();

          for (int i = 0; i < len; i++) {
              Node node = que.poll();
              levelItem.add(node.val);
              
              List<Node> children = (List<Node>) node.children;
              if (children == null || children.size() == 0) {
                  continue;
              }
              for (Node child : children) {
                  if (child != null) {
                      que.offer(child);
                  }
              }
          }
          res.add(levelItem);
      }
      return res;
  }
}

/**
 * 這題和429類似，用BFS遍歷樹的每一個節點
 * 不同的是這次多了孩子（children），因此比那裡每一層時需要再用一個列表來裝當前節點的所有子節點
 * 子節點為空的時候則繼續下一個循環，如果有子節點，就用增強for遍歷所有子節點
 **/