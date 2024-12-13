// Easy
// DFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/symmetric-tree/

class Solution {
  // Use DFS to check if the tree is symmetric
  // Recursively compare left subtree's left and right subtree's right (outside comparison)
  // Recursively compare left subtree's right and right subtree's left (inside comparison)
  // Return false if any mismatch in value or structure
  public boolean isSymmetric(TreeNode root) {
      return compare(root.left, root.right);
  }

  private boolean compare(TreeNode left, TreeNode right) {
      // basecases: both null -> symmetric; one null -> not symmetric
      if (left == null && right != null) return false;
      if (left != null && right == null) return false;
      if (left == null && right == null) return true;

      // compare value
      if (left.val != right.val) return false;

      // compare outside value & inside value
      boolean compareOutside = compare(left.left, right.right);
      boolean compareInside = compare(left.right, right.left);
      return compareOutside && compareInside;
  }
}
