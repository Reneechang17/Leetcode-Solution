// Medium
// DFS
// Time:O(N*min(M,H)),Space:O(H)
// https://leetcode.cn/problems/linked-list-in-binary-tree/

class Solution {
  // DFS to search the tree
  public boolean isSubPath(ListNode head, TreeNode root) {
      if (root == null) return false;
      // use root as start, dfs the subtree
      return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }
  private boolean dfs (TreeNode node, ListNode head) {
      if (head == null) return true; // all matched
      if (node == null) return false; // go through the end of tree
      if (node.val != head.val) return false;
      // check subtree
      return dfs(node.left, head.next) || dfs(node.right, head.next);
  }
}
