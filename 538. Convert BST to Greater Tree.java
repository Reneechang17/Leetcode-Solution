// Medium
// Tree
// O(N)
// Same: 1038
// https://leetcode.com/problems/convert-bst-to-greater-tree/

class Solution {
  int sum;
  public TreeNode convertBST(TreeNode root) {
      sum = 0;
      reverseInorder(root);
      return root;
  }
  public void reverseInorder(TreeNode root) {
      if (root == null) return;

      reverseInorder(root.right);
      sum += root.val;
      root.val = sum;
      reverseInorder(root.left);
  }
}

/**
 * 將二叉搜索樹轉換成一個累加樹
 * 可以先看一下example，會發現它的累加順序是右中左
 * 而BST的中序遍歷是有序的，所以我們要反中序的來遍歷這個BST
 **/