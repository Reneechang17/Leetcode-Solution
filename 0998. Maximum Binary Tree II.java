// Medium
// Recursion
// Time:O(h),Space:O(h)
// https://leetcode.cn/problems/maximum-binary-tree-ii/

class Solution {
  // Use the max value as root, if val>root.val, create new root with val
  //   - and original root as left subtree
  //   - or, insert into right subtree recursively, return updated root
  public TreeNode insertIntoMaxTree(TreeNode root, int val) {
      if (root == null) return new TreeNode(val);
      if (val > root.val) {
          TreeNode newRoot = new TreeNode(val);
          newRoot.left = root;
          return newRoot;
      }
      root.right = insertIntoMaxTree(root.right, val);
      return root;
  }
}
