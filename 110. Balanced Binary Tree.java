// Easy
// Tree, Recursion
// O(n)
// https://leetcode.com/problems/balanced-binary-tree/

class Solution {
  public boolean isBalanced(TreeNode root) {
      return getHeight(root) != -1;
  }
  private int getHeight(TreeNode root) {
      if (root == null) return 0;

      int leftHeight = getHeight(root.left);
      if (leftHeight == -1) return -1;

      int rightHeight = getHeight(root.right);
      if (rightHeight == -1) return -1;

      if (Math.abs(leftHeight - rightHeight) > 1) return -1;

      return Math.max(leftHeight, rightHeight) + 1;
  }
}

/**
 * 這題判斷一顆二叉樹是不是平衡二叉樹
 * 平衡二叉樹的定義：一個二叉樹的每個節點的左右兩個子樹的高度差的絕對值不超過1
 **/