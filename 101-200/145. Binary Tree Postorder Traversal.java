// Easy
// Tree
// O(n)
// https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      postorder(root, res);
      return res;
  }
  private void postorder (TreeNode root, List<Integer> res) {
      if (root == null) {
          return;
      }
      postorder(root.left, res);
      postorder(root.right, res);
      res.add(root.val);
  }
}

/**
 * 後序遍歷：左右中
 **/