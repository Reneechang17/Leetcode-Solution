// Easy
// DFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/evaluate-boolean-binary-tree/

class Solution {
  public boolean evaluateTree(TreeNode root) {
      if (root.left == null && root.right == null) {
          return root.val == 1;
      }
      boolean left = evaluateTree(root.left);
      boolean right = evaluateTree(root.right);
      return root.val == 2 ? (left || right) : (left && right);
  }
}
