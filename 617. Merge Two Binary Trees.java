// Easy
// Tree, Recursion
// O(N)
// https://leetcode.com/problems/merge-two-binary-trees/

class Solution {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 == null) return root2;
      if (root2 == null) return root1;

      root1.val += root2.val;
      root1.left = mergeTrees(root1.left, root2.left);
      root1.right = mergeTrees(root1.right, root2.right);
      return root1;
  }
}

/**
 * 合併兩個二叉樹
 * 
 * 其實更好理解的說法是合併兩個二叉樹對應節點的值
 * 為了節省空間可以直接在任一顆樹上操作即可（我的代碼是在root1上操作）
 * basecase是如果其中一顆二叉樹為空，直接返回另一顆
 * 如果當前都有值的話，root1.val直接加上root2的val
 * 然後遞歸處理兩顆樹的左右子樹
 **/