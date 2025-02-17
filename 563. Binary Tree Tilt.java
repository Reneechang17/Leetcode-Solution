// Easy
// Tree
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/binary-tree-tilt/

class Solution {
  // cur tree tilt:|leftSum - rightSum|
  // cur node'sum: leftSum + rightSum + root.val
  int sum = 0;
  public int findTilt(TreeNode root) {
      postOrder(root);
      return sum;
  }
  private int postOrder(TreeNode root) {
      if (root == null) return 0;
      int leftSum = postOrder(root.left);
      int rightSum = postOrder(root.right);
      sum += Math.abs(leftSum - rightSum);
      return leftSum + rightSum + root.val;
  }
}
