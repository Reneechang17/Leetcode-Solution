// Medium
// Tree
// O(n)
// https://leetcode.com/problems/path-sum-ii/

import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> res;
  LinkedList<Integer> path;

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      res = new LinkedList<>();
      path = new LinkedList<>();
      traversal(root, targetSum);
      return res;
  }
  private void traversal(TreeNode root, int target) {
      if (root == null) return;
      path.offer(root.val);
      target -= root.val;
      if (root.left == null && root.right == null && target == 0) {
          res.add(new LinkedList<>(path));
      }
      traversal(root.left, target);
      traversal(root.right, target);
      path.removeLast();
  }
}

/**
 * 這題是找出二叉樹其路徑的節點和為target的路徑
 * 這種要找二叉樹所有可能路徑的問題會涉及到回溯，並且會經常做頭尾的刪減，可以使用LinkedList
 * 
 * 檢查條件：如果已經到了葉子節點（左右都為null）並且target被減到0，則是找到一條有效的路徑
 * Note: 需要先判斷是否到達葉子節點，再看要不要繼續遞歸查
 **/