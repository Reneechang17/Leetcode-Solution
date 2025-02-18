// Medium
// DFS
// Time:O(n), Space:O(h)->h is the height of the tree
// https://leetcode.cn/problems/sum-root-to-leaf-numbers/

class Solution {
  public int sumNumbers(TreeNode root) {
      return dfs(root, 0);
  }

  private int dfs(TreeNode node, int curSum) {
      if (node == null) return 0;

      curSum = curSum * 10 + node.val;

      // if we reach the leaf node, return the curSum
      if (node.left == null && node.right == null) {
          return curSum;
      }

      // calculate the root to left leaf and root to right leaf
      int leftSum = dfs(node.left, curSum);
      int rightSum = dfs(node.right, curSum);
      return leftSum + rightSum;
  }
}
