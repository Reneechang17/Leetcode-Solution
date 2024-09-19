// Easy
// DFS
// O(n)
// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

class Solution {
  private int secondMin = -1;
  private int rootVal;

  public int findSecondMinimumValue(TreeNode root) {
      rootVal = root.val;
      dfs(root);
      return secondMin;
  }

  private void dfs (TreeNode node) {
      if (node == null) {
          return;
      }
      if (node.val > rootVal) {
          if (secondMin == -1 || node.val < secondMin) {
              secondMin = node.val;
          }
      }
      dfs(node.left);
      dfs(node.right);
  }
}

/**
 * 二叉樹中第二小的節點：給定一個二叉樹，每個節點的值都是正整數，對於每個非葉子節點，保證其值為兩個子節點中最小的值
 * 需要找到除了根節點以外第二小的節點值，如果不存在則返回-1
 * 
 * 思路：由於每個節點的值都可以大於或等於根節點的值，所以需要遍歷整個樹，尋找比根節點大的最小值，也就是第二小的值
 * 可以使用DFS從根節點開始遍歷，每次遞歸檢查當前節點的值是否比根節點大並且比當前的第二小值小，如果是的話，更新第二小值
 * 整個過程中我們只會保留第二小的值，並不斷更新它
 **/