// Medium
// DFS
// Time:O(n), Space:O(h)->h is the height of the tree
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

class Solution {
  // Recursive postorder traversal to flatten the tree
  // Move left subtree to right, find rightmost node, attach original right subtree
  public void flatten(TreeNode root) {
    if (root == null)
      return;
    // recursively faltten left and right subtree
    flatten(root.left);
    flatten(root.right);

    // temp store root.right
    TreeNode tmpRight = root.right;

    // move left subtree to right subtree
    root.right = root.left;
    root.left = null;

    // Find the rightmost mode
    // and attach the original right subtree
    TreeNode cur = root;
    while (cur.right != null) {
      cur = cur.right;
    }
    cur.right = tmpRight;
  }
}

// Optimization: use prev pointer -> Time: O(n)
class Solution2 {
  private TreeNode prev = null;
  public void flatten(TreeNode root) {
    if (root == null)
      return;
    
    flatten(root.right);
    flatten(root.left);
      
    root.right = prev;
    root.left = null;
    prev = root;
  }
}
