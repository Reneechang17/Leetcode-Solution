// Medium
// DFS, Recursion
// O(n)
// https://leetcode.com/problems/find-leaves-of-binary-tree/

import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> findLeaves(TreeNode root) {
      dfs(root);
      return res;
  }

  private int dfs(TreeNode root) {
      if(root == null) {
          return 0;
      }
      
      int left = dfs(root.left);
      int right = dfs(root.right);
      int h = Math.max(left, right);
      if (res.size() == h) {
          res.add(new ArrayList<>());
      }
      res.get(h).add(root.val);
      return h + 1;
  }
}

/**
 * 找到二叉樹的所有葉子節點：這題是一個經典的DFS遞歸問題，核心思路是計算每個節點的高度，然後根據高度將節點加入到對應的列表中
 **/