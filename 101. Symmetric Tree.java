// Easy
// DFS
// Time:O(n), Space:O(n)->worse case:a skewed tree, O(logn)->balanced tree
// https://leetcode.cn/problems/symmetric-tree/

class Solution {
  // DFS
  public boolean isSymmetric(TreeNode root) {
      return compare(root.left, root.right);
  }

  private boolean compare(TreeNode left, TreeNode right) {
      // basecase: if left or right is null -> false
      // but if both are null -> false
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
