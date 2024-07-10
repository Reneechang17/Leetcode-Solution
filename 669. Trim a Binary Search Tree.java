// Medium
// Tree,BST
// O(n)
// https://leetcode.com/problems/trim-a-binary-search-tree/

class Solution {
  public TreeNode trimBST(TreeNode root, int low, int high) {
      if (root == null) return null;

      if (root.val < low) {
          return trimBST(root.right, low, high);
      }

      if (root.val > high) {
          return trimBST(root.left, low, high);
      }

      root.left = trimBST(root.left, low, high);
      root.right = trimBST(root.right, low, high);
      return root;
  }
}

/**
 * 修剪二叉搜索樹：給定一個BST和最小邊界low & 最大邊界high
 * 使得所有節點的值都在[low, right]，可能需要改變樹的根節點
 * 
 * Note：因為整棵樹都要在範圍內，所以需要遍歷整個樹，確定每一個節點都在[low, right]
 * 
 * 對於當前遍歷到的節點值，我們先看他是否大於high or 小於low
 * 如果當前值小於下限的話，可以直接忽略當前節點值的左子樹（因為不在範圍內），直接遞歸右子樹
 * 
 * 當前節點在範圍內的話，就對對應的子樹做遞歸修剪，修剪後更新指針
 **/