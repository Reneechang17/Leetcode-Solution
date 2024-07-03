// Easy
// Tree
// O(n)
// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int maxDepth(Node root) {
      if (root == null) return 0;
      int depth = 0;

      Queue<Node> que = new LinkedList<>();
      que.offer(root);

      while (!que.isEmpty()) {
          int len = que.size();

          while (len-- > 0) {
              Node node = que.poll();
              for (int i = 0; i < node.children.size(); i++) {
                  if (node.children.get(i) != null)
                      que.offer(node.children.get(i));
              }
          }
          depth++;
      }
      return depth;
  }
}

/**
 * 這題是找N叉樹的最大深度
 * 和104思路類似，用層序遍歷+隊列遍歷樹，並另起一個depth變量紀錄即可
 **/