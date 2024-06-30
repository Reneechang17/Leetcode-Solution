// Medium
// Tree
// O(n)
// Similar: 102
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      LinkedList <List<Integer>> res = new LinkedList<>();

      Queue<TreeNode> que = new LinkedList<>();

      if (root != null) {
          que.offer(root);
      }

      while (!que.isEmpty()) {
          int len = que.size();
          List<Integer> temp = new ArrayList<>();

          for (int i = 0; i < len; i++) {
              TreeNode node = que.poll();
              temp.add(node.val);

              if (node.left != null) {
                  que.offer(node.left);
              }

              if (node.right != null) {
                  que.offer(node.right);
              }
          }
          res.addFirst(temp);
      }
      return res;
  }
}

/**
 * 這題只要在102的基礎上做反轉就可以了
 * 換個思路：也可以把每一層遍歷的addFirst實現反轉
 * Note：可以使用鏈表存儲res，鏈表對頭尾刪減比較高效
 **/