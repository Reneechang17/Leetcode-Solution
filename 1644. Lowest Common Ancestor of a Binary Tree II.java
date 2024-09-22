// Medium
// DFS, Recursion
// O(n)
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/

class Solution {
  private boolean foundP = false;
  private boolean foundQ = false;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode lca = findLCA(root, p, q);
      return (foundP && foundQ) ? lca : null;
  }
  
  private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
      if (node == null) {
          return null;
      }

      TreeNode left = findLCA(node.left, p, q);
      TreeNode right = findLCA(node.right, p, q);

      if (node == p) {
          foundP = true;
          return node;
      }

      if (node == q) {
          foundQ = true;
          return node;
      }

      if (left != null && right != null) {
          return node;
      }

      return (left != null) ? left : right;
  }
}

/**
 * 二叉樹的最近公共祖先II：這題和236的差別在於，給定的兩個節點不一定存在樹裡，如果只能找到其中一個節點找不到，就要返回null
 * 
 * 思路：可以用DFS來遍歷整個樹，同時判斷p和q是否存在於樹中，如果只找到其中一個，就返回null
 * 可以從根節點開始遞歸查找左右子樹，如果當前節點是p或是q，那我們可以將它看作是一個潛在的LCA
 * 如果左右子樹中有一個節點是null，那麼我們就返回另一個節點，因為這個節點是通過非空那邊傳回來的
 **/