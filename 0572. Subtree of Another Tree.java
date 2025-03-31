// Easy
// DFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/subtree-of-another-tree/

class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null) return false;

      // if cur is same as subtree, return true
      if (isSame(root, subRoot)) return true;
      // recursively check left and right subtree
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
  private boolean isSame(TreeNode root, TreeNode sub) {
      if (root == null && sub == null) return true;
      if (root == null || sub == null) return false;
      if (root.val != sub.val) return false;
      return isSame(root.left, sub.left) && isSame(root.right, sub.right);
  }
}
