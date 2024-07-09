// Medium
// Tree
// O(log n)
// Similar: 236
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > p.val && root.val > q.val)
      return lowestCommonAncestor(root.left, p, q);
    if (root.val < p.val && root.val < q.val)
      return lowestCommonAncestor(root.right, p, q);
    return root;
  }
}

/**
 * 二叉搜索樹的特性：中序遍歷的時候一定是有序的，所以當中間節點是q和p的公共祖先時，中間節點一定是在[p,q]之間
 * 那麽從上向下遍歷時遇到的第一個在[p,q]之間的中間節點就是q和p的公共祖先
 **/
