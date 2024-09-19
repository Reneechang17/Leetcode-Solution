// Easy
// DFS
// O(n)
// https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
  private int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
      depth(root);
      return diameter;
  }

  private int depth(TreeNode node) {
      if (node == null) {
          return 0;
      }

      int leftDepth = depth(node.left);
      int rightDepth = depth(node.right);

      diameter = Math.max(diameter, leftDepth + rightDepth);
      return Math.max(leftDepth, rightDepth) + 1;
  }
}

/**
 * 樹的直徑：給定一個二叉樹，找到這個二叉樹的直徑，直徑指的是樹中任意兩個節點路徑中最遠的距離（這個路徑不一定要經過根節點）
 * 
 * 二叉樹的直徑可以定義為某個節點的左子樹和右子樹的最大深度和。對於每個節點，我們需要計算從該節點通過其左右子樹的最長路徑
 * 目標是找到所有節點的這種最長路徑，並返回其中的最大值
 * 
 * 用DFS開遍歷整個樹，對於每個節點，計算其左右子樹的深度，並更新二叉樹的直徑
 * 節點的深度等於max（左子樹深度，右子樹深度）+ 1
 **/