// Medium
// DFS
// O(n)
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

class Solution {
  // BST -> sorted array
  private int t = 0, ans = 0;

  public int kthSmallest(TreeNode root, int k) {
      inorder(root, k);
      return ans;
      
  }

  private void inorder(TreeNode node, int k) {
      if (node == null) {
          return;
      }
      if (t == k) {
          return;
      }

      inorder(node.left, k);
      t++;
      if (t == k) {
          ans = node.val;
          return;
      }
      inorder(node.right, k);
  }
}
