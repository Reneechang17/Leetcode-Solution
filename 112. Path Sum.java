// Easy
// Tree
// O(n)
// https://leetcode.com/problems/path-sum/

class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) return false;

      targetSum -= root.val;
      if (root.left == null && root.right == null) return targetSum == 0;
      
      if (root.left != null) {
          boolean left = hasPathSum(root.left, targetSum);
          if (left) return true;
      }

      if (root.right != null) {
          boolean right = hasPathSum(root.right, targetSum);
          if (right) return true;
      }
      return false;
  }
}

/**
 * 題目給定一顆二叉樹和一個目標值，判斷是否有從根節點到葉子節點的路徑和給定的目標值是相等的
 * 
 * 遞歸遍歷二叉樹，每次將目標值遞減當前節點值，一旦找到就返回true
 **/