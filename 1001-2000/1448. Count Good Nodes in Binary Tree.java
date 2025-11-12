// Medium
// DFS
// O(n)
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

class Solution {
  private int ans = 0;

  public int goodNodes(TreeNode root) {
      // int n = Integer.MIN_VALUE;
      dfs(root, -100000);
      return ans;
  }

  private void dfs (TreeNode root, int max) {
      if (root == null) {
          return;
      }

      if (max <= root.val) {
          ans++;
          max = root.val;
      }
      dfs (root.left, max);
      dfs (root.right, max);
  }
}

/**
 * 二叉樹中好節點的個數：如果一個節點是好節點，表示它是它所在路徑（root～x）中最大值
 * 
 * 思路：這題就是看自己從root出發的路徑上是不是最大值，可以用DFS來遍歷，並用一個max來表示從根節點到當前路徑上的最大值（不包括當前節點）
 * max的初始化是一個極小值，因為節點可能是負數，所以不能初始化為0，可以用Integer.MIN_VALUE或是直接用-10^5（因為這題的數據量是正負10^4）
 **/