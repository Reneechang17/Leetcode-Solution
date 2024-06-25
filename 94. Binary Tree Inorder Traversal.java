// Easy
// Tree
// O(n)
// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      inorder (root, res);
      return res;
  }
  private void inorder(TreeNode root, List<Integer> res) {
      if(root == null) {
          return;
      }
      inorder(root.left, res);
      res.add(root.val);
      inorder(root.right, res);
  }
}

/**
 * 中序遍歷：左中右
 **/