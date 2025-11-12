// Easy
// DFS, Counting
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/find-mode-in-binary-search-tree/

import java.util.*;

class Solution {
  // BST' inorder traversal can form the ordered arr
  // same elements will appear constantly, then calculate appear times to find the mode

  private Integer prev = null;
  private int count = 0, maxCount = 0;
  private List<Integer> modes = new ArrayList<>();

  public int[] findMode(TreeNode root) {
      inorder(root);

      int[] res = new int[modes.size()];
      for (int i = 0; i < modes.size(); i++) {
          res[i] = modes.get(i);
      }
      return res;
  }
  private void inorder(TreeNode root) {
      if (root == null) return;
      inorder(root.left);

      if (prev != null && root.val == prev) {
          count++;
      } else {
          count = 1;
      }

      // update mode number
      if (count > maxCount) {
          maxCount = count;
          modes.clear();
          modes.add(root.val); // add cur val
      } else if (count == maxCount) {
          modes.add(root.val);
      }

      prev = root.val; // update prev value
      
      inorder(root.right);
  }
}
