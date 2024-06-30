// Medium
// Tree, BFS
// O(n)
// https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      Deque<TreeNode> que = new LinkedList<>();

      if (root == null) {
          return res;
      }

      que.offer(root);
      while (!que.isEmpty()) {
          int len = que.size();
          for (int i = 0; i < len; i++) {
              // 層序遍歷
              TreeNode poll = que.pollFirst();
              if (poll.left != null) {
                  que.add(poll.left);
              }
              if (poll.right != null) {
                  que.add(poll.right);
              }

              // 收集當前層的最後一個節點
              if (i == len - 1) {
                  res.add(poll.val); // 
              }
          }
      }
      return res;
  }
}

/**
 * 這題是尋找二叉樹的右視圖節點
 * 其實就是要找層序遍歷中的最後一個節點
 * 可以用層序遍歷+Queue來遍歷每一層節點
 * 當遍歷到當前層最後一個節點的時候，將其節點收集到res列表中
 **/