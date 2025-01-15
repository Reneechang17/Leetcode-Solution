// Easy
// https://leetcode.cn/problems/root-equals-sum-of-children/

class Solution {
  public boolean checkTree(TreeNode root) {
      int sum = root.left.val + root.right.val;
      if (sum == root.val) return true;
      return false;
  }
}
