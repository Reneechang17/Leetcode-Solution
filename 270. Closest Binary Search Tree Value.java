// Easy
// Tree, DFS
// O(n)
// https://leetcode.com/problems/closest-binary-search-tree-value/

class Solution {
  private int ans;
  private double target;
  private double diff = Double.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {
      this.target = target;
      dfs (root);
      return ans;
  }

  private void dfs (TreeNode node) {
      if (node == null) {
          return;
      }

      double next = Math.abs(node.val - target);
      if (next < diff || (next == diff && node.val < ans)) {
          diff = next;
          ans = node.val;
      }

      node = target < node.val ? node.left : node.right;
      dfs(node);
  }
}

/**
 * 給一個二叉搜索樹的根節點和一個目標值target，找出這個二叉搜索樹種最接近target的數值，如果有多個答案，返回最小的那個
 * 
 * 用dfs遍歷二叉搜索樹，比較當前值與target的差值的絕對值，並更新答案。由於二叉搜索樹的特性，小的會在root的左邊，大的會在右邊
 * 如果target小於當前節點，則往左邊查，反則右邊
 **/
