// Medium
// BST
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/recover-binary-search-tree/

class Solution {
  // inorder traversal -> sorted arr
  TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

  public void recoverTree(TreeNode root) {
      inorder(root);
      int tmp = first.val;
      first.val = second.val;
      second.val = tmp;
  }
  private void inorder(TreeNode node) {
      if (node == null) return;
      inorder(node.left);
      if (prev.val > node.val) {
          if (first == null) first = prev; // first time meet mistake
          second = node; // update second mistake node
      }
      prev = node; // update prev
      inorder(node.right);
  }
}
