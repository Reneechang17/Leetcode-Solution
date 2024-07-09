// Medium
// Tree
// O(n)
// Similar: 235
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) return root;

      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if (left == null && right == null) {
          return null;
      } else if (left != null && right == null) {
          return left;
      } else if (left == null && right != null) {
          return right;
      } else {
          return root;
      }
  }
}

/**
 * 二叉樹的最近公共祖先
 * 
 * 根據題目，有兩種公共祖先的情況
 * 1. 左子樹出現p，右子樹出現q or 左子樹出現q，右子樹出現p，那麼該節點就是最近的公共祖先
 * 2. pq自己就是最近的公共祖先
 * 
 * 這題用後序遍歷（左右中）
 * 
 * Note：如果左右都不為空，那麼root就是最近公共祖先
 * 如果其中一邊是空的，那麼直接返回另一邊，因為目標節點是通過非空那邊傳回來了
 **/