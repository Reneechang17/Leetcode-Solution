// Easy
// Tree, BFS, Count
// O(n)
// https://leetcode.com/problems/find-mode-in-binary-search-tree/

import java.util.ArrayList;

class Solution {
  ArrayList<Integer> modes;
  int maxCount;
  int count;
  TreeNode pre;

  public int[] findMode(TreeNode root) {
    modes = new ArrayList<>();
    maxCount = 0;
    count = 0;
    pre = null;

    inorder(root);

    int[] res = new int[modes.size()];
    for (int i = 0; i < modes.size(); i++) {
      res[i] = modes.get(i);
    }
    return res;
  }

  private void inorder(TreeNode root) {
    if (root == null)
      return;

    inorder(root.left);
    int rootVal = root.val;

    if (pre == null || rootVal != pre.val) {
      count = 1;
    } else {
      count++;
    }

    if (count > maxCount) {
      modes.clear();
      modes.add(rootVal);
      maxCount = count;
    } else if (count == maxCount) {
      modes.add(rootVal);
    }
    pre = root;
    inorder(root.right);
  }
}

// 找二叉搜索樹的眾數

// 如果不是二叉搜索樹，只是單純的數組？ => 用map統計頻率，把頻率排序找出最高頻的元素
// 根據二叉搜索樹的特性，他的中序遍歷一定是有序的
// Note：眾數可以不只一個，所以尋找眾數需要用一個列表裝起來
// findMode方法用於找眾數，另外寫一個inorder方法做遞歸
