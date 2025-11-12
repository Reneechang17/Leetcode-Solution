// Easy
// Tree
// O(log N)
// https://leetcode.com/problems/search-in-a-binary-search-tree/

class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
      if (root == null) return null;
      if (val == root.val) return root;

      if (val < root.val) return searchBST(root.left, val);
      else return searchBST(root.right, val);
  }
}

/**
 * 在二叉搜索樹中搜索值
 * 
 * 二叉搜索樹的特點是大的都在root的右邊，小的都在root的左邊（和root的值比）
 * 可以根據這個特性優化（log N）
 * 
 * 如果root == null的話直接返回null。root的值等於要找的值的話，直接返回root
 * 然後看val是否小於root的值，如果小於往左邊找，大於往右邊找
 **/