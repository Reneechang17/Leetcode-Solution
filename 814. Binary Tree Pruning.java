// Medium
// Tree
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/binary-tree-pruning/

class Solution {
  // Use postorder recursion to process left and right
  //  - if subtree only contain 0, return null and remove it
  //  - if root itself is 0, and has no child, remove it
  public TreeNode pruneTree(TreeNode root) {
      if (root == null) return null;
      root.left = pruneTree(root.left);
      root.right = pruneTree(root.right);
      if (root.val == 0 && root.left == null && root.right == null) {
          return null;
      }
      return root;
  }
}
