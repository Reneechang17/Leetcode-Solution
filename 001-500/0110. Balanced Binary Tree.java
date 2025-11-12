// Easy
// Tree
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/balanced-binary-tree/

class Solution {
  public boolean isBalanced(TreeNode root) {
      return getHeight(root) != -1;
  }
  private int getHeight(TreeNode root) {
      if (root == null) return 0;

      int leftHeight = getHeight(root.left);
      if (leftHeight == -1) return -1; // if left tree not balance
      int rightHeight = getHeight(root.right);
      if (rightHeight == -1) return -1; // if right tree not balance

      // if cur node not balance
      if (Math.abs(leftHeight - rightHeight) > 1) return -1; 
      return Math.max(leftHeight, rightHeight) + 1; // return cur height
  }
}
