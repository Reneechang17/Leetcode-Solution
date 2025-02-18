// Medium
// Tree, DFS
// Time:O(nlogn),Space:O(nlogn)
// https://leetcode.cn/problems/print-binary-tree/

import java.util.*;
class Solution {
  public List<List<String>> printTree(TreeNode root) {
      int height = getHeight(root);
      int width = (int)Math.pow(2, height + 1) - 1;

      List<List<String>> res = new ArrayList<>();
      // initialize
      for (int i = 0; i <= height; i++) {
          List<String> row = new ArrayList<>(Collections.nCopies(width, ""));
          res.add(row);
      }

      // fill matrix
      fill(root, res, 0, 0, width - 1);
      return res;
  }
  private int getHeight(TreeNode root) {
      if (root == null) return -1;
      return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  private void fill(TreeNode root, List<List<String>> res, int row, int left, int right) {
      if (root == null) return;
      int mid = (left + right) >> 1;
      res.get(row).set(mid, String.valueOf(root.val));
      fill(root.left, res, row + 1, left, mid - 1);
      fill(root.right, res, row + 1, mid + 1, right);
  }
}

// row=h+1, col=2^(h+1)-1, root in the middle
// 计算h，创建h+1行，2^(h+1)-1列的矩阵，初始化为""
// 递归填充：根结点放在(0, mid), mid=(left+right)>>1
// 左子树放在(row+1, mid-left), 右子树放在(row+1, mid-right)
