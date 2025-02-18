// Medium
// Recursion, Simulation
// O(n)
// https://leetcode.cn/problems/binary-tree-upside-down/

class Solution {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
      // 原樹的左孩子是新的根節點
      // 原樹的根節點變成新樹的右孩子
      // 原樹的右孩子變成新樹的左孩子
      if (root == null || root.left == null) {
          return root;
      }

      TreeNode newRoot = upsideDownBinaryTree(root.left);
      root.left.left = root.right;
      root.left.right = root;
      // 清除原樹根節點的左孩子和右孩子
      root.left = null;
      root.right = null;
      return newRoot;
  }
}
