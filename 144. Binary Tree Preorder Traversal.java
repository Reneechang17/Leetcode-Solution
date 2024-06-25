// Easy
// Tree
// O(n)
// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorder(root, res);
    return res;
  }

  private void preorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val);
    preorder(root.left, res);
    preorder(root.right, res);
  }
}

/**
 * 前序遍歷：中左右
 **/