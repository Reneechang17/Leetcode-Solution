// Easy
// Tree, Recursion
// Time:O(log^2n), Space:O(logn)
// https://leetcode.cn/problems/count-complete-tree-nodes/

class Solution {
  // 未优化, 遍历所有节点
  // Time: O(n), Space: O(h)
  public int countNodes(TreeNode root) {
      // basecase 
      if (root == null) return 0;

      return countNodes(root.left) + countNodes(root.right) + 1;
  }
}

// 优化：因为给定是一颗完全二叉树，其每层除了最后一层都是满的，并且最后一层节点从左到右连续排列
// 如果树是满的，节点总数就是= 2^h - 1; 如果不是满的，可以递归处理左右子树
// Time:O(log^2n), Space:O(logn)
class Solution2 {
  public int countNodes(TreeNode root) {
      if (root == null) return 0;

      // 计算左右子树的高度
      int leftHeight = getHeight(root.left);
      int rightHeight = getHeight(root.right);

      if (leftHeight == rightHeight) {
          // 左右高度相等，即树是满的
          return (int) Math.pow(2, leftHeight) + countNodes(root.right);
      } else {
          // 左右高度不相等，则递归计算
          return (int) Math.pow(2, rightHeight) + countNodes(root.left);
      }

  }

  private int getHeight(TreeNode node) {
      int h = 0;
      while (node != null) {
          h++;
          node = node.left; // 完全二叉树只需要沿着左边遍历
      }
      return h;
  }
}
