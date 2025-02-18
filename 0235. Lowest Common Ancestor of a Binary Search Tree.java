// Medium
// Tree, Recursion
// O(log n) -> Solution; O(n) -> Solution2
// Similar: 236
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) return root;

      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if (left != null && right != null) {
          return root;
      }

      return left != null ? left : right;
  }
}

// 優化：BST的中序排序是有序數組，表示這個節點一定在[p,q]之間，也就是從上到下遍歷過程第一個遇到在這個區間的節點就是LCA
// 有序數組中的第一個節點 -> 可以用二分思路縮小範圍 -> O(logn)

class Solution2 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // 如果當前節點的值大於pq節點的值 -> 往左邊找
      if (root.val > p.val && root.val > q.val) {
          return lowestCommonAncestor(root.left, p, q);
          // 相反 -> 往右邊找
      } else if (root.val < p.val && root.val < q.val) {
          return lowestCommonAncestor(root.right, p, q);
      } else {
          return root;
      }
  }
}
