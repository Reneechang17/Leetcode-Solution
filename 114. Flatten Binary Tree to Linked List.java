// Medium
// DFS
// Time:O(n), Space:O(h)->h is the height of the tree
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

class Solution {
  // 从树的底部开始后序遍历，将左子树插入右子树之前，最后将左子树设置为null
  // 找新的右子树的最右节点，将原来的右子树接到这个节点的右子树
  public void flatten(TreeNode root) {
      // basecase
      if (root == null) return;

      flatten(root.left);
      flatten(root.right);

      // store the right subtree
      TreeNode tempRight = root.right;

      // move the left subtree to the right
      root.right = root.left;
      root.left = null;

      // Attach the original right subtree to the end of the new right subtree
      TreeNode cur = root;
      while (cur.right != null) {
          cur = cur.right;
      }
      cur.right = tempRight;
  }
}
