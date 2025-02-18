// Easy
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/minimum-absolute-difference-in-bst/

class Solution {
  // BST中序遍历是一个有序数组，在有序数组中，最小绝对差必然会出现在相邻两个节点之间
  private int minDiff = Integer.MAX_VALUE;
  private TreeNode prev = null;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  private void inorder(TreeNode node) {
    if (node == null)
      return;
    inorder(node.left);
    if (prev != null) {
      minDiff = Math.min(minDiff, node.val - prev.val);
    }
    prev = node;
    inorder(node.right);
  }
}
