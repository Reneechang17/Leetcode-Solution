// Medium
// Tree, Recursion
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/maximum-binary-tree/

class Solution {
  // Find cur max value and its index, and use it as root
  // Recursively construct the left subtree -> nums[0:maxIndex]
  // Also recursively construct the right subtree -> nums[maxIndex+1:end]
  public TreeNode constructMaximumBinaryTree(int[] nums) {
      return buildTree(nums, 0, nums.length - 1);
  }
  private TreeNode buildTree(int[] nums, int left, int right) {
      if (left > right) return null;

      // find max value and its index
      int maxIndex = left;
      for (int i = left; i <= right; i++) {
          if (nums[i] > nums[maxIndex]) {
              maxIndex = i;
          }
      }

      // create root node
      TreeNode root = new TreeNode(nums[maxIndex]);

      // recursively construct left and right subtree
      root.left = buildTree(nums, left, maxIndex - 1);
      root.right = buildTree(nums, maxIndex + 1, right);

      return root;
  }
}
